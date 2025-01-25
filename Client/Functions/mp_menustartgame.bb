Function mp_menustartgame%(arg0%, arg1%, arg2.mp_netbuffer)
    Local local0%
    Local local1%
    Local local2%
    mp_menu\Field0 = arg0
    mp_menu\Field1 = arg1
    local0 = blitz_mp_readbyte0(arg2)
    If (local0 <> $08) Then
        Return $01
    EndIf
    local1 = blitz_mp_readbyte0(arg2)
    ue_server\Field8 = blitz_mp_readbyte0(arg2)
    If (local1 >= ue_server\Field8) Then
        Return $02
    EndIf
    ue_server\Field4 = blitz_mp_readline0(arg2)
    blitz_mp_readline0(arg2)
    randomseed = blitz_mp_readline0(arg2)
    opt\Field50 = blitz_mp_readbyte0(arg2)
    If (opt\Field50 <> $00) Then
        senddebuglog("Intro enabled")
    EndIf
    selecteddifficulty = difficulties[(Int min((Float blitz_mp_readbyte0(arg2)), 4.0))]
    If (selecteddifficulty\Field5 <> 0) Then
        selecteddifficulty\Field2 = blitz_mp_readbyte0(arg2)
        selecteddifficulty\Field3 = blitz_mp_readbyte0(arg2)
        selecteddifficulty\Field9 = blitz_mp_readbyte0(arg2)
        selecteddifficulty\Field4 = blitz_mp_readbyte0(arg2)
        senddebuglog("CustomDifficulty found. Checking for custom settings...")
        senddebuglog(("AgressiveNPC's: " + (Str selecteddifficulty\Field2)))
        senddebuglog(("Savetype: " + (Str selecteddifficulty\Field3)))
        senddebuglog(("InventorySlots: " + (Str selecteddifficulty\Field9)))
        senddebuglog(("OtherFactors: " + (Str selecteddifficulty\Field4)))
    EndIf
    local2 = (blitz_mp_readbyte0(arg2) * $3E8)
    If (local2 = $00) Then
        local2 = $FFFFFC18
    EndIf
    mp_initvoice($FFFFFFFF, $BB80, local2, $800)
    mp_addlistserver(dottedip(arg0), arg1, $01)
    senddebuglog(("Got random seed: " + randomseed))
    currsave = (New save)
    loadcustommaps()
    currcustommap = (New custommaps)
    initnewgame()
    mainmenuopen = $00
    shoulddeletegadgets = $01
    Return mp_menu\Field2
    Return $00
End Function
