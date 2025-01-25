Function mp_server_usedoor%(arg0.mp_player)
    Local local0$
    Local local1#
    Local local2.items
    Local local3.doors
    Local local4%
    Local local5%
    Local local6$
    Local local7%
    Local local8.rooms
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13.doors
    Local local14.items
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
    local8 = playerroom
    local9 = mp_readshort()
    local10 = mp_readbyte()
    local11 = mp_readint()
    local12 = mp_readshort()
    currentsyncplayer = arg0
    If (local9 < $1F4) Then
        local13 = mp_doors[local9]
        If (((local13 <> Null) And (20.0 > entitydistancesquared(arg0\Field18, local13\Field2))) <> 0) Then
            playerroom = mp_rooms[arg0\Field22]
            selecteditem = Null
            If (local12 < $3E8) Then
                local14 = mp_items[local12]
                If (local14 <> Null) Then
                    If (local14\Field27 = arg0\Field5) Then
                        selecteditem = local14
                    EndIf
                EndIf
            EndIf
            d_i\Field9 = local13\Field3[$00]
            d_i\Field11 = $01
            If (local10 <= $02) Then
                d_i\Field9 = local13\Field3[(local10 - $01)]
                d_i\Field11 = local10
            EndIf
            d_i\Field7 = local13
            msg\Field5 = (Str local11)
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
    playerroom = local8
    currentsyncplayer = Null
    Return $00
End Function
