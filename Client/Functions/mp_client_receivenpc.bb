Function mp_client_receivenpc%(arg0%)
    Local local0.npcs
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    local0 = mp_npcs[arg0]
    local1 = mp_readbyte()
    If (local0 = Null) Then
        local0 = createnpc(local1, 0.0, 0.0, 0.0)
        mp_initializenpc(local0, arg0)
    ElseIf (local0\Field4 <> local1) Then
        removenpc(local0)
        local0 = createnpc(local1, 0.0, 0.0, 0.0)
        mp_initializenpc(local0, arg0)
    EndIf
    local0\Field97 = $00
    local2 = mp_readbyte()
    local3 = mp_readbyte()
    local0\Field50 = readbool(local2, $00)
    local0\Field10 = 0.0
    local0\Field11 = 0.0
    local0\Field12 = 0.0
    local0\Field28 = 0.0
    local0\Field26 = 0.0
    local0\Field69 = $00
    local0\Field70 = $00
    local0\Field34 = Null
    local0\Field36 = 0.0
    local0\Field37 = 0.0
    local0\Field38 = 0.0
    local0\Field60 = $00
    If (readbool(local2, $01) <> 0) Then
        local0\Field10 = mp_readfloat()
    EndIf
    If (readbool(local2, $02) <> 0) Then
        local0\Field11 = mp_readfloat()
    EndIf
    If (readbool(local2, $03) <> 0) Then
        local0\Field12 = mp_readfloat()
    EndIf
    If (readbool(local2, $04) <> 0) Then
        local0\Field28 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local2, $05) <> 0) Then
        local0\Field34 = mp_npcs[mp_readbyte()]
    EndIf
    If (readbool(local2, $06) <> 0) Then
        local0\Field69 = mp_readbyte()
        local0\Field70 = mp_readbyte()
    EndIf
    If (readbool(local2, $07) <> 0) Then
        local0\Field26 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local3, $00) <> 0) Then
        local0\Field36 = mp_readfloat()
        local0\Field37 = mp_readfloat()
        local0\Field38 = mp_readfloat()
    EndIf
    local0\Field74 = mp_readfloat()
    local0\Field75 = mp_readfloat()
    local0\Field76 = mp_readfloat()
    local0\Field77 = convertshorttofloat(mp_readshort(), 10.0)
    local0\Field78 = convertshorttofloat(mp_readshort(), 10.0)
    local0\Field79 = convertunsignedshorttofloat(mp_readshort(), 10.0)
    local4 = convertunsignedshorttofloat(mp_readshort(), 10.0)
    local5 = convertunsignedshorttofloat(mp_readshort(), 10.0)
    If (((local4 <> local0\Field86) Lor (local5 <> local0\Field87)) <> 0) Then
        local0\Field82 = local4
        local0\Field86 = local4
        local0\Field87 = local5
    EndIf
    local0\Field88 = convertshorttofloat(mp_readshort(), 100.0)
    local0\Field89 = readbool(local3, $04)
    If (readbool(local3, $01) <> 0) Then
        changenpctextureid(local0, (mp_readbyte() - $01))
    EndIf
    local0\Field65 = readbool(local3, $02)
    If (readbool(local3, $03) <> 0) Then
        local0\Field60 = mp_readshort()
    EndIf
    local0\Field43 = readbool(local3, $05)
    If ((readbool(local3, $06) And (local0\Field63 = $00)) <> 0) Then
        createnpcasset(local0)
    EndIf
    If (mp_events[local0\Field69] <> Null) Then
        mp_events[local0\Field69]\Field1\Field15[local0\Field70] = local0
    EndIf
    local0\Field73 = $01
    Return $00
End Function
