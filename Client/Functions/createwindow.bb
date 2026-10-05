Function createwindow%(arg0%, arg1%, arg2%, arg3%, arg4$)
    apptitle((arg4 + multiplayer_version), "")
    graphics3d(arg0, arg1, arg2, arg3)
    win\Field0 = (Int systemproperty("AppHWND"))
    win\Field11 = api_getcurrentprocessid()
    win\Field2 = arg0
    win\Field3 = arg1
    win\Field8 = arg2
    win\Field9 = arg3
    win\Field12 = ((Float arg0) / 1024.0)
    win\Field13 = ((Float arg1) / 768.0)
    win\Field1 = arg4
    win\Field14 = millisecs()
    smallest_power_two = $80
    While (((smallest_power_two < arg0) Or (smallest_power_two < arg1)) <> 0)
        smallest_power_two = (smallest_power_two Shl $01)
    Wend
    smallest_power_two_half = (smallest_power_two Shr $01)
    setupwindow()
    api_showwindow(win\Field0, $01)
    Return $00
End Function
