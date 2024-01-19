Function allistenerupdate%(arg0%)
    Local local0#
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    local0 = entityx(arg0, $01)
    local1 = entityy(arg0, $01)
    local2 = entityz(arg0, $01)
    allistenersetposition(local0, local1, local2)
    tformvector(0.0, 0.0, -10.0, arg0, $00)
    local3 = (Int tformedx())
    local4 = (Int tformedy())
    local5 = (Int tformedz())
    allistenersetdirection((Float local3), (Float local4), (Float local5))
    tformvector(0.0, 10.0, 0.0, arg0, $00)
    local3 = (Int tformedx())
    local4 = (Int tformedy())
    local5 = (Int tformedz())
    allistenersetup((Float local3), (Float local4), (Float local5))
    Return $00
End Function
