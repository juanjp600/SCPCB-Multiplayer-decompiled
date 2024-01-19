Function creategun.guns(arg0%, arg1%, arg2$, arg3$, arg4$, arg5$, arg6#, arg7%, arg8%, arg9%, arg10#, arg11#, arg12#, arg13#, arg14#, arg15#, arg16#, arg17#, arg18#, arg19#)
    Local local0.guns
    Local local1%
    local0 = (New guns)
    local0\Field0 = arg0
    local0\Field1 = arg7
    local0\Field2 = arg8
    local0\Field18 = arg9
    local0\Field32 = arg9
    local0\Field4 = arg6
    local0\Field10 = loadanimmesh_strict(arg2, $00)
    If ((((local0\Field0 = $0D) Or (local0\Field0 = $0E)) Or (local0\Field0 = $0F)) <> 0) Then
        rotatemesh(local0\Field10, 0.0, -90.0, 0.0)
    EndIf
    local0\Field11 = arg10
    scaleentity(local0\Field10, arg11, arg12, arg13, $00)
    entityparent(local0\Field10, gunpivot, $01)
    moveentity(local0\Field10, arg14, arg15, arg16)
    hideentity(local0\Field10)
    local0\Field20 = arg3
    local0\Field19 = loadsound_strict(arg3)
    local0\Field9 = loadsound_strict(arg4)
    local0\Field21 = loadsound_strict(arg5)
    local0\Field23 = arg1
    local0\Field24 = createsprite($00)
    entityparent(local0\Field24, gunpivot, $01)
    moveentity(local0\Field24, arg17, arg18, arg19)
    entitytexture(local0\Field24, muzzleflash, $00, $00)
    entityfx(local0\Field24, $09)
    spriteviewmode(local0\Field24, $03)
    entityblend(local0\Field24, local1)
    scalesprite(local0\Field24, 0.07, 0.07)
    hideentity(local0\Field24)
    addshoottickstogun(local0, $01)
    addspreadratetogun(local0, 1.0)
    local0\Field25 = arg14
    local0\Field26 = arg15
    local0\Field27 = arg16
    meshcullbox(local0\Field10, (- meshwidth(local0\Field10)), (- meshheight(local0\Field10)), (- meshdepth(local0\Field10)), (meshwidth(local0\Field10) * 8.0), (meshheight(local0\Field10) * 8.0), (meshdepth(local0\Field10) * 8.0))
    gun_info[arg0] = local0
    Return local0
    Return Null
End Function
