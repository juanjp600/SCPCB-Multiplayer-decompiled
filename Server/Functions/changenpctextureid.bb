Function changenpctextureid%(arg0.npcs, arg1%)
    Local local0%
    Local local1%
    Local local2#
    If (arg0 = Null) Then
        If (local0 <> 0) Then
            local1 = $01
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
    local2 = (0.5 / meshwidth(arg0\Field0))
    scaleentity(arg0\Field0, local2, local2, local2, $00)
    setnpcframe(arg0, arg0\Field14)
    Return $00
End Function
