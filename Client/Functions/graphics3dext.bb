Function graphics3dext%(arg0%, arg1%, arg2%, arg3%)
    freeallfonts($00, $01)
    graphics3d(arg0, arg1, arg2, arg3)
    smallest_power_two = 512.0
    While ((((Float arg0) > smallest_power_two) Or ((Float arg1) > smallest_power_two)) <> 0)
        smallest_power_two = (smallest_power_two * 2.0)
    Wend
    smallest_power_two_half = (smallest_power_two / 2.0)
    initexternalsound()
    initfastresize()
    antialias(getiniint(optionfile, "options", "antialias", $00))
    Return $00
End Function
