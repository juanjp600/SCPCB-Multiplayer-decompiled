Function createrolecorpse%(arg0.players, arg1%)
    Local local0.corpses
    Local local1%
    local0 = (New corpses)
    local0\Field1 = arg1
    local0\Field2 = entityx(arg0\Field62, $00)
    local0\Field3 = entityy(arg0\Field62, $00)
    local0\Field4 = entityz(arg0\Field62, $00)
    local0\Field5 = converttoshort(arg0\Field3)
    local0\Field7 = (Int (player[local1]\Field28 * 100.0))
    local0\Field6 = (millisecs() + $1D4C0)
    local0\Field8 = 420.0
    local0\Field0 = findfreecorpseid()
    m_corpse[local0\Field0] = local0
    Return $00
End Function
