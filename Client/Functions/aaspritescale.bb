Function aaspritescale%(arg0%, arg1%, arg2%)
    scaleentity(aatextsprite[arg0], ((1.0 / (Float aacamvieww)) * (Float arg1)), ((1.0 / (Float aacamvieww)) * (Float arg2)), 1.0, $00)
    aacharw = arg1
    aacharh = arg2
    Return $00
End Function
