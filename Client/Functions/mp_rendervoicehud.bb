Function mp_rendervoicehud%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7#)
    Local local0%
    If (((mp_voice = Null) Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = $0E
    If (mp_getvoicerecording() <> 0) Then
        local0 = $0F
    EndIf
    If (mp_voice\Field6 <> 0) Then
        local0 = $10
    EndIf
    arg5 = (arg5 - arg2)
    renderbar(blinkmeterimg, (Int arg4), (Int arg5), (Int arg6), (Int arg7), mp_voice\Field5, 100.0, $64, $64, $64)
    color($FF, $FF, $FF)
    rect((Int (arg4 - arg0)), (Int arg5), (Int arg1), (Int arg1), $00)
    drawblock(t\Field0[local0], (Int (arg4 - arg3)), (Int (arg5 + 1.0)), $00)
    Return $01
    Return $00
End Function
