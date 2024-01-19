Function se_array_addelement.se_value(arg0.se_array)
    Local local0.se_value
    Local local1%
    local0 = (New se_value)
    local1 = (arg0\Field1 Shl $02)
    arg0\Field1 = (arg0\Field1 + $01)
    resizebank(arg0\Field2, (arg0\Field1 Shl $02))
    pokeint(arg0\Field2, local1, (Handle local0))
    Return local0
    Return Null
End Function
