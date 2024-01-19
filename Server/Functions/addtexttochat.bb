Function addtexttochat%(arg0$, arg1%)
    Local local0%
    Local local1.chatmessage
    Local local2%
    local0 = $00
    For local1 = Each chatmessage
        local0 = (local0 + $01)
    Next
    While (local0 >= $1E)
        Delete (First chatmessage)
        local0 = (local0 - $01)
    Wend
    globalmessages = ((globalmessages Mod $10000) + $01)
    local1 = (New chatmessage)
    local1\Field1 = arg0
    local1\Field2 = (millisecs() + $1388)
    local1\Field0 = globalmessages
    For local2 = $01 To server\Field18 Step $01
        If (arg1 = $00) Then
            local1\Field3[local2] = $01
        ElseIf (arg1 = local2) Then
            local1\Field3[local2] = $01
        Else
            local1\Field3[local2] = $00
        EndIf
    Next
    Return $00
End Function
