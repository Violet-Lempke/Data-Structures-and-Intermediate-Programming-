#!/usr/bin/perl
use 5.26.0;
use warnings FATAL => 'all';
use feature qw(signatures);
no warnings "experimental::signatures";
use lib './.lib';

use Test::Simple tests => 7;
use Data::Dumper;

our %EXPECT_TESTS = (
    PrimesAaShould => 3,
    PrimesBbShould => 1,
    PrimesCcShould => 1,
);
our $PKG = "lab12";

use JUnit;

my @reports = JUnit::list_reports();

my %seen = map { $_ => 1 } @reports;
for my $xx (sort keys %EXPECT_TESTS) {
    my $name = "$PKG.$xx";
    my $expect = $EXPECT_TESTS{$xx};

    unless (exists($seen{$name})) {
        for (1...$expect) {
            ok(0, "In $name, test report missing.");
        }
        next;
    }

    my $report = JUnit::read_report($name);

    my $jvers = $report->java_version();
    say "# Java VM: $jvers";

    my $summary = $report->summary();
    my $ran = $summary->{tests};
    my $passed = $ran - $summary->{fails} - $summary->{errors};
    for my $ii (1...$passed) {
        ok(1, "Successfully passed $ii/$expect tests in $name");
    }
    for my $ii (($passed + 1)...($expect)) {
        ok(0, "In $name, failed test $ii/$expect tests");
    }
}

use CheckStyle;

my @errors = CheckStyle->list_errors();
my $count = scalar @errors;

ok($count < 10, "Less than 10 style errors");
ok($count == 0, "No style errors");

if ($count > 0) {
    say "#";
    say "# You had some style errors, here they are:";
    for my $err (@errors) {
        my $file = $err->{file};
        $file =~ s/^.*\///;
        my $line = $err->{line};
        my $text = $err->{text};
        say "#   $file:$line => $text";
    }
}
