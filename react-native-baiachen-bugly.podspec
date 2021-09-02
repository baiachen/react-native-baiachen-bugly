
Pod::Spec.new do |s|
  s.name         = "react-native-baiachen-bugly"
  s.version      = "1.0.3"
  s.summary      = "RNBugly"
  s.homepage     = "https://github.com/baiachen/react-native-bugly"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "baiachen" => "zcbaia@gmail.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/baiachen/react-native-bugly.git", :tag => "master" }
  s.source_files  = "ios/RNBugly/**/*.{h,m}"
  #s.requires_arc = true
  s.preserve_paths  = "**/*.js"

  s.ios.frameworks    = "SystemConfiguration", "Security"
  s.ios.library = 'z', 'c++'

  s.dependency "Bugly"

  #s.dependency "React"
  #s.dependency "others"

end
