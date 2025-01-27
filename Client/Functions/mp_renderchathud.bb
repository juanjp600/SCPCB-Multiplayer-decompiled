Function mp_renderchathud%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.mp_chatmessage
    If (((mp_getsocket() = $00) And (mp_chat\Field3 > $00)) <> 0) Then
        Return $00
    EndIf
    local0 = mp_chat\Field2
    local1 = mp_chat\Field3
    setfontex(fo\Field0[$00])
    local1 = (Int ((Float local1) - (15.0 * menuscale)))
    local2 = $00
    local3 = (Last mp_chatmessage)
    While (((local3 <> Null) And (local2 <= $32)) <> 0)
        local1 = (Int ((Float local1) - (((Float getlineamountleft(local3\Field0, (Int ((500.0 * menuscale) + (4.0 * menuscale))), (Int (80.0 * menuscale)), (Int (25.0 * menuscale)))) * 25.0) * menuscale)))
        color($1E, $1E, $1E)
        rowtextleft(local3\Field0, (Int ((2.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int ((500.0 * menuscale) + (4.0 * menuscale))), opt\Field50, (Int (25.0 * menuscale)))
        color($FF, $FF, $FF)
        rowtextleft(local3\Field0, local0, local1, (Int ((500.0 * menuscale) + (4.0 * menuscale))), opt\Field50, (Int (25.0 * menuscale)))
        local2 = (local2 + $01)
        local3 = (Before local3)
    Wend
    If (mp_chat\Field0 <> 0) Then
        rendermenuinputboxes()
    EndIf
    Return $00
End Function
