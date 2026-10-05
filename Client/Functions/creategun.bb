Function creategun.guns(arg0%, arg1%, arg2$, arg3$, arg4$, arg5$, arg6#, arg7%, arg8%, arg9%, arg10#, arg11#, arg12#, arg13#, arg14#, arg15#, arg16#, arg17#, arg18#, arg19#)
    Local local0.guns
    Local local1%
    local0 = (New guns)
    local0\Field0 = arg0
    local0\Field1 = arg7
    local0\Field2 = arg8
    local0\Field18 = arg9
    local0\Field34 = arg9
    local0\Field4 = arg6
    local0\Field38 = createpivot(gunpivot)
    local0\Field10 = loadanimmesh_strict(arg2, $00)
    local0\Field11 = arg10
    scaleentity(local0\Field10, (arg11 * 1.0), (arg12 * 1.0), (arg13 * 1.0), $00)
    entityparent(local0\Field10, local0\Field38, $01)
    moveentity(local0\Field10, (arg14 * 1.0), ((arg15 - 0.04) * 1.0), (arg16 * 1.0))
    entitypickmode(local0\Field10, $00, $00)
    applyreflection(local0\Field10)
    hideentity(local0\Field10)
    local0\Field21 = arg3
    local0\Field20 = loadsound_strict(arg3)
    local0\Field9 = loadsound_strict(arg4)
    local0\Field22 = loadsound_strict(arg5)
    local0\Field24 = arg1
    local0\Field25 = createsprite($00)
    entityparent(local0\Field25, local0\Field38, $01)
    moveentity(local0\Field25, (arg17 * 1.0), ((arg18 - 0.04) * 1.0), (arg19 * 1.0))
    entitytexture(local0\Field25, muzzleflash, $00, $00)
    entityfx(local0\Field25, $09)
    entityorder(local0\Field25, $FFFFD8F1)
    entityblend(local0\Field25, $03)
    scalesprite(local0\Field25, 0.07, 0.07)
    hideentity(local0\Field25)
    addshoottickstogun(local0, $01)
    addspreadratetogun(local0, 1.0)
    local1 = findchild(local0\Field10, "Sight")
    If (local1 <> $00) Then
        local0\Field26 = local1
        local0\Field27 = (- entityx(local1, $01))
        local0\Field28 = (- entityy(local1, $01))
        local0\Field29 = (- entityz(local1, $01))
    EndIf
    meshcullbox(local0\Field10, (- meshwidth(local0\Field10)), (- meshheight(local0\Field10)), (- meshdepth(local0\Field10)), (meshwidth(local0\Field10) * 8.0), (meshheight(local0\Field10) * 8.0), (meshdepth(local0\Field10) * 8.0))
    gun_info[arg0] = local0
    Return local0
    Return Null
End Function
