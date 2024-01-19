Function create3dicon%(arg0%, arg1%, arg2$, arg3$, arg4#, arg5#, arg6#, arg7#, arg8#, arg9#, arg10#, arg11#, arg12#, arg13%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local0 = createimage(arg0, arg1, $01)
    local1 = createcamera($00)
    camerarange(local1, 0.01, 16.0)
    cameraviewport(local1, $00, $00, arg0, arg1)
    If (arg13 <> 0) Then
        camerafogmode(local1, $01)
        camerafogrange(local1, camerafognear, camerafogfar)
    EndIf
    If (right(lower(arg2), $06) = ".rmesh") Then
        local2 = loadrmesh(arg2, Null)
    Else
        local2 = loadmesh_strict(arg2, $00)
    EndIf
    local3 = loadtexture_strict(arg3, $01)
    scaleentity(local2, arg10, arg11, arg12, $00)
    positionentity(local2, arg4, arg5, arg6, $00)
    rotateentity(local2, arg7, arg8, arg9, $00)
    entitytexture(local2, local3, $00, $00)
    renderworld(1.0)
    copyrect($00, $00, arg0, arg1, $00, $00, backbuffer(), imagebuffer(local0, $00))
    freeentity(local2)
    freeentity(local1)
    freetexture(local3)
    Return local0
    Return $00
End Function
