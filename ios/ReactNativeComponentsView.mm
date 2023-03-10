#ifdef RCT_NEW_ARCH_ENABLED
#import "ReactNativeComponentsView.h"

#import <react/renderer/components/RNReactNativeComponentsViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNReactNativeComponentsViewSpec/EventEmitters.h>
#import <react/renderer/components/RNReactNativeComponentsViewSpec/Props.h>
#import <react/renderer/components/RNReactNativeComponentsViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface ReactNativeComponentsView () <RCTReactNativeComponentsViewViewProtocol>

@end

@implementation ReactNativeComponentsView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<ReactNativeComponentsViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const ReactNativeComponentsViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<ReactNativeComponentsViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<ReactNativeComponentsViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> ReactNativeComponentsViewCls(void)
{
    return ReactNativeComponentsView.class;
}

@end
#endif
