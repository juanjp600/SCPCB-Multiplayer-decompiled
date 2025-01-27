Function graphics3dex%(arg0%, arg1%, arg2%, arg3%)
    setgfxdriver(opt\Field52)
    graphics3d(arg0, arg1, arg2, arg3)
    texturefilter("", $2000)
    smallest_power_two = 512.0
    While ((((Float arg0) > smallest_power_two) Lor ((Float arg1) > smallest_power_two)) <> 0)
        smallest_power_two = (smallest_power_two * 2.0)
    Wend
    smallest_power_two_half = (smallest_power_two / 2.0)
    initfastresize()
    Return $00
End Function
