Function steambrowser_create.steambrowser(arg0%, arg1%, arg2$, arg3$, arg4$)
    Local local0.steambrowser
    local0 = (New steambrowser)
    local0\Field0 = $00
    local0\Field2[$00] = arg0
    local0\Field2[$01] = arg1
    local0\Field3 = arg2
    local0\Field1 = bs_isteamhtmlsurface_createbrowser(bs_steamhtmlsurface(), arg3, arg4)
    bs_callback_registerresult(steambrowser_callback_browserready_c, local0\Field1, $1195)
    bs_callback_register(steambrowser_callback_needspaint_c, $1196)
    bs_callback_register(steambrowser_callback_startrequest_c, $1197)
    local0\Field9 = createimage(local0\Field2[$00], local0\Field2[$01], $01)
    local0\Field10 = createtexture(local0\Field2[$00], local0\Field2[$01], $03, $01)
    Return local0
    Return Null
End Function
