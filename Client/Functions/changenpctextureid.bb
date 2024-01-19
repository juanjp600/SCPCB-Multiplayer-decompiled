Function changenpctextureid%(arg0.npcs, arg1%)
    Local local0#
    If (arg0 = Null) Then
        createconsolemsg("Tried to change the texture of an invalid NPC", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    If ((((arg1 + $01) < $01) Or ((arg1 + $01) > $0B)) <> 0) Then
        Return $00
    EndIf
    If (arg0\Field67 = (arg1 + $01)) Then
        Return $00
    EndIf
    arg0\Field67 = (arg1 + $01)
    freeentity(arg0\Field0)
    arg0\Field0 = copyentity(dtextures[(arg1 + $01)], $00)
    local0 = (0.5 / meshwidth(arg0\Field0))
    scaleentity(arg0\Field0, local0, local0, local0, $00)
    meshcullbox(arg0\Field0, (- meshwidth(classdobj)), (- meshheight(classdobj)), (- meshdepth(classdobj)), (meshwidth(classdobj) * 2.0), (meshheight(classdobj) * 2.0), (meshdepth(classdobj) * 2.0))
    setnpcframe(arg0, arg0\Field14)
    Return $00
End Function
