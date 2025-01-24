Function mp_renderchathud%(arg0#, arg1#)
    Local local0%
    Local local1.mp_chatmessage
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    If (1.0 <= arg1) Then
        mp_chat\Field2 = (Int arg0)
        mp_chat\Field3 = (Int arg1)
    EndIf
    arg0 = (Float mp_chat\Field2)
    arg1 = (Float mp_chat\Field3)
    setfontex(fo\Field0[$00])
    arg1 = (arg1 - (15.0 * menuscale))
    local0 = $00
    local1 = (Last mp_chatmessage)
    While (((local1 <> Null) And (local0 <= $32)) <> 0)
        arg1 = (arg1 - (((Float getlineamountleft(local1\Field0, (Int ((500.0 * menuscale) + (4.0 * menuscale))), (Int (80.0 * menuscale)), (Int (25.0 * menuscale)))) * 25.0) * menuscale))
        color($1E, $1E, $1E)
        rowtextleft(local1\Field0, (Int ((2.0 * menuscale) + arg0)), (Int ((2.0 * menuscale) + arg1)), (Int ((500.0 * menuscale) + (4.0 * menuscale))), opt\Field47, (Int (25.0 * menuscale)))
        color($FF, $FF, $FF)
        rowtextleft(local1\Field0, (Int arg0), (Int arg1), (Int ((500.0 * menuscale) + (4.0 * menuscale))), opt\Field47, (Int (25.0 * menuscale)))
        local0 = (local0 + $01)
        local1 = (Before local1)
    Wend
    If (mp_chat\Field0 <> 0) Then
        rendermenuinputboxes()
    EndIf
    Return $00
End Function
