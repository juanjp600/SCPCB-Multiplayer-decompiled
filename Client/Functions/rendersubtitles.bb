Function rendersubtitles%()
    Local local0.subtitlesmsg
    Local local1%
    Local local2#
    Local local3%
    Local local4#
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field25 = $00)) <> 0) Then
        Return $00
    EndIf
    local1 = $00
    For local0 = Each subtitlesmsg
        local1 = (local1 + $01)
    Next
    local2 = ((subassets\Field5 + (Float subassets\Field0)) - (Float (subassets\Field0 * local1)))
    local3 = (Int (5.0 * menuscale))
    local4 = (Float ((subassets\Field0 * local1) + local3))
    If (local1 = $00) Then
        local4 = (local4 - (Float local3))
    EndIf
    subassets\Field1 = curvevalue(local2, subassets\Field1, 7.0)
    subassets\Field2 = curvevalue(local4, subassets\Field2, 7.0)
    color($14, $14, $14)
    rect((Int subassets\Field4), (Int subassets\Field1), (Int subassets\Field3), (Int subassets\Field2), $01)
    local1 = $FFFFFFFF
    setfontex(fo\Field0[$00])
    For local0 = Each subtitlesmsg
        local1 = (local1 + $01)
        local0\Field2 = (((Float (subassets\Field0 * local1)) + local2) + (Float (local3 Shl $01)))
        local0\Field3 = curvevalue(local0\Field2, local0\Field3, 7.0)
        If (opt\Field26 <> 0) Then
            color((Int ((Float (local0\Field5 + opt\Field27)) / 2.0)), (Int ((Float (local0\Field6 + opt\Field28)) / 2.0)), (Int ((Float (local0\Field7 + opt\Field29)) / 2.0)))
        Else
            color(local0\Field5, local0\Field6, local0\Field7)
        EndIf
        textex((Int (subassets\Field4 + (10.0 * menuscale))), (Int local0\Field3), local0\Field10, $00, $00)
    Next
    color($FF, $FF, $FF)
    Return $00
End Function
