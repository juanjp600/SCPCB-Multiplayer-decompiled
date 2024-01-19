Function se_parsechunks%()
    Local local0.se_chunk
    se_current_token = (First se_token)
    While (se_current_token <> Null)
        local0 = (New se_chunk)
        local0\Field1 = se_current_token
        If (se_current_token\Field0 = $0C) Then
            local0\Field0 = $01
            se_current_token = (After se_current_token)
        ElseIf (((se_current_token\Field0 = $09) Or (se_current_token\Field0 = $0D)) <> 0) Then
            local0\Field0 = $03
            se_current_token = (After se_current_token)
        ElseIf (se_current_token\Field0 = $0E) Then
            local0\Field0 = $04
            se_current_token = (After se_current_token)
        Else
            local0\Field0 = $02
            local0\Field2 = (New se_node)
            local0\Field2\Field1 = $01
            se_parseexpression(local0\Field2, se_current_token)
        EndIf
    Wend
    Return $00
End Function
