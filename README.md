Configuration
=============

You guys are going to hate me for this. There's quite a bit of setup required for the site.

Prerequisites
-------------

* Ruby
* Compass
* ZURB Foundation
* Jekyll
* Vagrant host box

### Ruby

I recommend installing Ruby through [RVM](https://rvm.io/), but you're going to have a lot of fun doing that if you're on Windows. If you're on Windows you should probably just use the [RubyInstaller](http://rubyinstaller.org/).


### Compass

    $ gem install compass


### ZURB Foundation

    $ gem install zurb-foundation


### Jekyll

    $ gem install jekyll


Generate the Site
-----------------

    $ jekyll serve

You can now access the site at [http://localhost:4000](http://localhost:4000).

You're going to need to regenerate the site each time you change any of the source files. If you want Jekyll to automatically regenerate files when they're changed run the following:

    $ jekyll serve --watch