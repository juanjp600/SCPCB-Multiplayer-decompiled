Function se_parseblocks%(arg0.se_block)
    Local local0%
    If (arg0 = Null) Then
        se_current_chunk = (First se_chunk)
        se_root_block = (New se_block)
        arg0 = se_root_block
        local0 = $01
    EndIf
    While (se_current_chunk <> Null)
        If (((se_current_chunk\Field0 = $01) And (se_current_chunk\Field1\Field1 = "end")) <> 0) Then
            If (local0 <> 0) Then
                se_error_unexpected(se_current_chunk\Field1)
                Return $00
            Else
                se_current_chunk = (After se_current_chunk)
                Exit
            EndIf
        ElseIf (se_current_chunk\Field0 = $04) Then
            If (local0 <> 0) Then
                Exit
            Else
                se_error(arg0\Field3, "unexpected end of construction (encountered end of file)", $01)
                Return $00
            EndIf
        EndIf
        If (se_parseblock(arg0) <> 0) Then
            Exit
        EndIf
        If (se_error <> 0) Then
            Return $00
        EndIf
        se_current_chunk = (After se_current_chunk)
    Wend
    Return $00
End Function
