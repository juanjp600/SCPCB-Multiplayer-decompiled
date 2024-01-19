Function multiplayer_createmessage.chatmessage(arg0$, arg1%)
    Local local0.chatmessage
    If (arg1 >= $00) Then
        For local0 = Each chatmessage
            If (local0\Field3 = arg1) Then
                Return Null
            EndIf
        Next
    EndIf
    local0 = (New chatmessage)
    Insert local0 Before (First chatmessage)
    local0\Field0 = arg0
    local0\Field1 = (millisecs() + $4E20)
    local0\Field2 = 1400.0
    local0\Field3 = arg1
    If (local0\Field0 <> getformattedtext(local0\Field0)) Then
        local0\Field4 = $01
    EndIf
    Return local0
    Return Null
End Function
