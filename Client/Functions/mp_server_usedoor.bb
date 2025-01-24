Function mp_server_usedoor%(arg0.mp_player)
    Local local0$
    Local local1#
    Local local2.items
    Local local3.doors
    Local local4%
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12.doors
    Local local13.items
    If (determinepacketflooding(arg0, $02, $01, $FA) <> 0) Then
        Return $00
    EndIf
    local0 = msg\Field0
    local1 = msg\Field1
    local2 = selecteditem
    local3 = d_i\Field7
    local4 = d_i\Field9
    local5 = d_i\Field11
    local6 = msg\Field5
    local7 = me\Field60
    local8 = mp_readshort()
    local9 = mp_readbyte()
    local10 = mp_readint()
    local11 = mp_readshort()
    currentsyncplayer = arg0
    If (local8 < $1F4) Then
        local12 = mp_doors[local8]
        If (((local12 <> Null) And (20.0 > entitydistancesquared(arg0\Field18, local12\Field2))) <> 0) Then
            If (local11 < $3E8) Then
                local13 = mp_items[local11]
                If (local13 <> Null) Then
                    If (local13\Field27 = arg0\Field5) Then
                        selecteditem = local13
                    EndIf
                EndIf
            EndIf
            d_i\Field9 = local12\Field3[$00]
            d_i\Field11 = $01
            If (local9 <= $02) Then
                d_i\Field9 = local12\Field3[(local9 - $01)]
                d_i\Field11 = local9
            EndIf
            d_i\Field7 = local12
            msg\Field5 = (Str local10)
            me\Field60 = arg0\Field18
            If (2.25 > entitydistancesquared(arg0\Field18, d_i\Field9)) Then
                usedoor($01)
            EndIf
        EndIf
    EndIf
    msg\Field0 = local0
    msg\Field1 = local1
    selecteditem = local2
    d_i\Field7 = local3
    d_i\Field9 = local4
    d_i\Field11 = local5
    msg\Field5 = local6
    me\Field60 = local7
    currentsyncplayer = Null
    Return $00
End Function
