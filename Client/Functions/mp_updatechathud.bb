Function mp_updatechathud%()
    Local local0#
    Local local1#
    Local local2.mp_chatmessage
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    If (((((mp_chat\Field0 Lor menuopen) Lor consoleopen) = $00) And keyhit(key\Field15)) <> 0) Then
        mp_chat\Field0 = (mp_chat\Field0 = $00)
        If (mp_chat\Field0 <> 0) Then
            selectedinputbox = $3ED
        EndIf
        flushkeys()
        stopmousemovement()
    EndIf
    If (mp_chat\Field0 <> 0) Then
        local0 = (Float mp_chat\Field2)
        local1 = (Float mp_chat\Field3)
        mp_chat\Field1 = updatemenuinputbox((Int local0), (Int local1), (Int (600.0 * menuscale)), (Int (30.0 * menuscale)), mp_chat\Field1, $00, $3ED, $90, 0.05)
        If (keyhit($1C) <> 0) Then
            If (len(mp_chat\Field1) > $00) Then
                mp_createchatmessage(((opt\Field46 + ": ") + mp_chat\Field1))
                mp_sendchatmessage(mp_chat\Field1)
                mp_chat\Field1 = ""
            EndIf
            mp_chat\Field0 = $00
            shoulddeletegadgets = $01
            flushkeys()
        EndIf
        ismultiplayerhudenabled = $01
        menuopen = $00
        consoleopen = $00
    EndIf
    For local2 = Each mp_chatmessage
        local2\Field1 = (local2\Field1 - fps\Field7[$00])
        If (0.0 >= local2\Field1) Then
            Delete local2
        EndIf
    Next
    Return $00
End Function
