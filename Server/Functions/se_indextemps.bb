Function se_indextemps%()
    Local local0.se_functiondef
    Local local1.se_tempvalue
    Local local2%
    For local0 = Each se_functiondef
        local1 = local0\Field5
        local2 = local0\Field0\Field4
        While (local1 <> Null)
            local1\Field0\Field0 = $04
            local1\Field0\Field2 = local2
            local2 = (local2 + $01)
            local1 = local1\Field1
        Wend
        local0\Field0\Field4 = local2
    Next
    Return $00
End Function
