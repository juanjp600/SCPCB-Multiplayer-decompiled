Function applybumpmap%(arg0%)
    textureblend(arg0, $06)
    texturebumpenvmat(arg0, $00, $00, -0.015)
    texturebumpenvmat(arg0, $00, $01, -0.015)
    texturebumpenvmat(arg0, $01, $00, 0.015)
    texturebumpenvmat(arg0, $01, $01, 0.015)
    texturebumpenvoffset(arg0, 0.5)
    texturebumpenvscale(arg0, 1.0)
    Return $00
End Function
