# react-native-bugly

## Getting started

`$ npm install react-native-baiachen-bugly --save`

### Mostly automatic installation

`$ react-native link react-native-baiachen-bugly`

### 配置

#### iOS

使用 Bugly 的 Info.plist 配置初始化信息
Bugly 支持读取 Info.plist 文件读取 SDK 初始化参数，可配置的参数如下：

- Appid
  - Key: BuglyAppIDString
  - Value: 字符串类型
- 渠道标识
  - Key: BuglyAppChannelString
  - Value: 字符串类型
- 版本信息
  - Key: BuglyAppVersionString
  - Value: 字符串类型
- 开启 Debug 信息显示
  - Key: BuglyDebugEnable
  - Value: BOOL 类型

### Manual installation

#### iOS

node node_modules/react-native-baiachen-bugly/scripts/postlink

#### Android TODO

1. Open up `android/app/src/main/java/[...]/MainActivity.java`

- Add `import com.reactlibrary.RNBuglyPackage;` to the imports at the top of the file
- Add `new RNBuglyPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
   ```
   include ':react-native-baiachen-bugly'
   project(':react-native-baiachen-bugly').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-baiachen-bugly/android')
   ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
     compile project(':react-native-baiachen-bugly')
   ```

## Usage

AppDelegate.m

```objective-c
#import "RNBugly.h"
-(BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  //Add Bugly
  [RNBugly startWithAppId];
}
```

```javascript
import RNBugly from "react-native-baiachen-bugly";

// TODO: What to do with the module?
RNBugly;
```
