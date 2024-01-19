Function steambrowser_setsize%(arg0.steambrowser, arg1%, arg2%)
    arg0\Field2[$00] = arg1
    arg0\Field2[$01] = arg2
    bs_isteamhtmlsurface_setsize(bs_steamhtmlsurface(), arg0\Field0, arg1, arg2)
    freeimage(arg0\Field9)
    arg0\Field9 = createimage(arg1, arg2, $01)
    freetexture(arg0\Field10)
    arg0\Field10 = createtexture(arg1, arg2, $03, $01)
    Return $00
End Function
