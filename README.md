Glass Fork Information
======================

This is a fork of Nix on Android for Google Glass. Besides just making the
necessary changes for the app to run properly on Glass, the other changes were
made:

* The extra keys bar has been removed. It's expected that you have a keyboard of
  some kind connected to your device.
* The session list view has been removed. Key commands are the only way to
  switch between sessions.
* And, speaking of key commands, the Termux built-in `Ctrl+Alt+<key>` commands
  have all been moved as not to interfere with TUI apps like Emacs. Instead,
  these shortcuts can be accessed by pressing `Ctrl+Alt+Escape`, then pressing a
  single key corresponding to the action. These can be viewed in
  `TermuxViewClient.java`.
* Likewise, a new option has been added to `termux.settings` to allow you to
  choose if right alt should be interpreted as `Alt` or `AltGr`. The default is
  `Alt`, which differs from vanilla Termux. Many settings that were made
  obsolete by other changes were removed as well. See `TermuxPreferences.java`.
* Basically, this shit's optimized to run Emacs on your face.

The original [nix-on-droid-app](https://github.com/t184256/nix-on-droid-app)'s
readme begins here.

Fork information
================

Nix on Android, in a single-click installable package.
It's kind of a mess for now, but hey, it works!

This repository is a fork of Termux-the-terminal-emulator used to execute
Nix-on-Droid.

All credit goes to Termux:

* https://github.com/termux/termux-app
* https://termux.com

For the script responsible for the initial bootstrap zipball generation
please refer to https://github.com/t184256/nix-on-droid-bootstrap



Original README starts here:

[![Travis build status](https://travis-ci.org/termux/termux-app.svg?branch=master)](https://travis-ci.org/termux/termux-app)
[![Join the chat at https://gitter.im/termux/termux](https://badges.gitter.im/termux/termux.svg)](https://gitter.im/termux/termux)


Termux app
==========

[Termux](https://termux.com) is an Android terminal app and Linux environment.

* [Termux on Google Play Store](https://play.google.com/store/apps/details?id=com.termux)
* [Termux on F-Droid](https://f-droid.org/repository/browse/?fdid=com.termux)
* [Termux Google+ community](http://termux.com/community/)
* [Termux Wiki](https://wiki.termux.com/wiki/)
* [Termux Twitter](http://twitter.com/termux/)

Note that this repository is for the app itself (the user interface and the terminal emulation). For the packages installable inside the app, see [termux/termux-packages](https://github.com/termux/termux-packages)

Terminal resources
==================
* [XTerm control sequences](http://invisible-island.net/xterm/ctlseqs/ctlseqs.html)
* [vt100.net](http://vt100.net/)
* [Terminal codes (ANSI and terminfo equivalents)](http://wiki.bash-hackers.org/scripting/terminalcodes)

Terminal emulators
==================
* VTE (libvte): Terminal emulator widget for GTK+, mainly used in gnome-terminal. [Source](https://github.com/GNOME/vte), [Open Issues](https://bugzilla.gnome.org/buglist.cgi?quicksearch=product%3A%22vte%22+), and [All (including closed) issues](https://bugzilla.gnome.org/buglist.cgi?bug_status=RESOLVED&bug_status=VERIFIED&chfield=resolution&chfieldfrom=-2000d&chfieldvalue=FIXED&product=vte&resolution=FIXED).
* iTerm 2: OS X terminal application. [Source](https://github.com/gnachman/iTerm2), [Issues](https://gitlab.com/gnachman/iterm2/issues) and [Documentation](http://www.iterm2.com/documentation.html) (which includes [iTerm2 proprietary escape codes](http://www.iterm2.com/documentation-escape-codes.html)).
* Konsole: KDE terminal application. [Source](https://projects.kde.org/projects/kde/applications/konsole/repository), in particular [tests](https://projects.kde.org/projects/kde/applications/konsole/repository/revisions/master/show/tests), [Bugs](https://bugs.kde.org/buglist.cgi?bug_severity=critical&bug_severity=grave&bug_severity=major&bug_severity=crash&bug_severity=normal&bug_severity=minor&bug_status=UNCONFIRMED&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&product=konsole) and [Wishes](https://bugs.kde.org/buglist.cgi?bug_severity=wishlist&bug_status=UNCONFIRMED&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&product=konsole).
* hterm: JavaScript terminal implementation from Chromium. [Source](https://github.com/chromium/hterm), including [tests](https://github.com/chromium/hterm/blob/master/js/hterm_vt_tests.js), and [Google group](https://groups.google.com/a/chromium.org/forum/#!forum/chromium-hterm).
* xterm: The grandfather of terminal emulators. [Source](http://invisible-island.net/datafiles/release/xterm.tar.gz).
* Connectbot: Android SSH client. [Source](https://github.com/connectbot/connectbot)
* Android Terminal Emulator: Android terminal app which Termux terminal handling is based on. Inactive. [Source](https://github.com/jackpal/Android-Terminal-Emulator).
