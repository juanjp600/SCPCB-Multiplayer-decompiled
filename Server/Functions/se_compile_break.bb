Function se_compile_break%(arg0.se_block)
    Local local0.se_blockspace
    local0 = (Last se_blockspace)
    If (local0\Field2 = Null) Then
        local0\Field2 = se_vf_createlabel()
    EndIf
    se_vf_createinst($18, se_vf_getlabel(local0\Field2), Null, Null)
    Return $00
End Function
