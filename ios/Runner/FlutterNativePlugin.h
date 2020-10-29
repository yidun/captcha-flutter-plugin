//
//  FlutterNativePlugin.h
//  Runner
//
//  Created by 罗礼豪 on 2020/9/22.
//

#import <Foundation/Foundation.h>
#import <Flutter/Flutter.h>
#import <VerifyCode/NTESVerifyCodeManager.h>

NS_ASSUME_NONNULL_BEGIN

@interface FlutterNativePlugin : NSObject <FlutterPlugin, NTESVerifyCodeManagerDelegate,FlutterStreamHandler>

@property(nonatomic, strong) NTESVerifyCodeManager *manager;
@property (nonatomic, strong) FlutterEventSink eventSink;

+ (FlutterNativePlugin *)sharedInstance;

- (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar;

@end

NS_ASSUME_NONNULL_END
