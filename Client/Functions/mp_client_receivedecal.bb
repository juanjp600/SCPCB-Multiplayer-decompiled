Function mp_client_receivedecal%()
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14%
    Local local15#
    Local local16#
    Local local17%
    Local local18.decals
    local0 = mp_readbyte()
    local1 = mp_readfloat()
    local2 = mp_readfloat()
    local3 = mp_readfloat()
    local4 = convertshorttofloat(mp_readshort(), 10.0)
    local5 = convertshorttofloat(mp_readshort(), 10.0)
    local6 = convertshorttofloat(mp_readshort(), 10.0)
    local7 = mp_readfloat()
    local8 = mp_readfloat()
    local9 = mp_readfloat()
    local10 = mp_readfloat()
    local11 = mp_readfloat()
    local12 = mp_readbyte()
    local13 = mp_readbyte()
    local14 = mp_readbyte()
    local15 = mp_readfloat()
    local16 = mp_readfloat()
    local17 = mp_readbyte()
    local18 = createdecal(local0, local1, local2, local3, local4, local5, local6, local7, local10, $00, $01, local12, local13, local14)
    local18\Field5 = local9
    local18\Field4 = local8
    local18\Field7 = local11
    local18\Field13 = local15
    local18\Field14 = local16
    If (mp_rooms[local17] <> Null) Then
        entityparent(local18\Field0, mp_rooms[local17]\Field2, $01)
    EndIf
    Return $00
End Function
