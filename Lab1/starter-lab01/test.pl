#!/usr/bin/perl
use 5.26.0;
use warnings FATAL => 'all';
use feature qw(signatures);
no warnings "experimental::signatures";

my $REPORT_COUNT = 2;
use Test::Simple tests => 4;
use XML::Parser;
use Data::Dumper;

check_crc("src/test/java/lab01/AppShould.java", "2b4c7471");
check_crc("src/test/java/lab01/RocketShould.java", "144d5ad6");

my @reports = glob("target/surefire-reports/TEST*xml");
if (scalar @reports != $REPORT_COUNT) {
    say "No test reports";
    die "run 'mvn verify'";
}

for my $path (@reports) {
    check_report($path);
}

sub check_crc($path, $correct) {
    return if $^O =~ /mswin/i;
    my $crc = `crc32 $path`;
    chomp $crc;
    die "Corrupted file: $path" if $crc ne $correct;
}

sub check_report($path) {
    my $par = XML::Parser->new(Style => 'Objects', Pkg => 'X');
    my $tree = $par->parsefile($path);

    for my $node (@$tree) {
        $node->visit();
    }
}

package X::testsuite;

sub visit($self) {
    my $tests = $self->{tests};
    my $fails = $self->{failures};
    my $errors = $self->{errors};

    say "# Tests: $tests, Fails: $fails, Errors: $errors";

    for my $kid (@{$self->{Kids}}) {
        $kid->visit();
    }
}

package X::properties;

sub visit($self) {
    for my $kid (@{$self->{Kids}}) {
        $kid->visit();
    }
}

package X::property;

sub visit($self) {
    my $name = $self->{name};
    my $value = $self->{value};

    if ($name eq 'java.runtime.version') {
        say "# java.runtime.version: $value";
    }
}

package X::testcase;

use Test::Simple;

sub visit($self) {
    my $name = $self->{name};
    my $fails = $self->count_fails();
    ok($fails == 0, $name);
    if ($fails > 0) {
        say $self->get_comment();
    }
}

sub count_fails($self) {
    my $fails = 0;
    for my $kid (@{$self->{Kids}}) {
        $fails += $kid->count_fails();
    }
    return $fails;
}

sub get_comment($self) {
    my $text = "";
    for my $kid (@{$self->{Kids}}) {
        $text .= $kid->get_comment();
    }
    return $text;
}

package X::failure;

use Data::Dumper;

sub count_fails($self) {
    return 1;
}

sub get_comment($self) {
    my $text = "";
    for my $kid (@{$self->{Kids}}) {
        $text .= $kid->get_comment();
    }
    return $text;
}

package X::error;

use Data::Dumper;

sub count_fails($self) {
    return 1;
}

sub get_comment($self) {
    my $text = "";
    for my $kid (@{$self->{Kids}}) {
        $text .= $kid->get_comment();
    }
    return $text;
}

package X::Characters;

sub visit($self) {
    # do nothing
}

sub count_fails($self) {
    # Text isn't a fail
    return 0;
}

sub get_comment($self) {
    my $text = $self->{Text};
    if ($text =~ /^\s*$/) {
        return "";
    }
    else {
        $text = "\n$text\n";
        $text =~ s/^/# /mg;
        $text =~ s/\n+$//;
        return $text;
    }
}
