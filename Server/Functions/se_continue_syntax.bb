Function se_continue_syntax%(arg0.se_block)
    Local local0.se_blockspace
    Local local1%
    local0 = (Last se_blockspace)
    While (local0 <> Null)
        local1 = local0\Field0\Field0
        If ((((local1 = $09) Or (local1 = $0A)) Or (local1 = $0B)) <> 0) Then
            Return $00
        EndIf
        local0 = (Before local0)
    Wend
    se_error(arg0\Field3, "'continue' without any loop", $01)
    Return $00
End Function
