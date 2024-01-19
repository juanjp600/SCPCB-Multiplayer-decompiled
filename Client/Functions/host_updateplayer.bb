Function host_updateplayer%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1.items
    player[arg0]\Field43 = readbool(arg3, $00)
    player[arg0]\Field35 = (Float ((player[arg0]\Field55 >= $05) And (player[arg0]\Field55 <= $0A)))
    If (mainmenuopen <> 0) Then
        Return $00
    EndIf
    local0 = $00
    If (((player[arg0]\Field73 <> player[arg0]\Field51) Or ((readbool(arg3, $04) = $01) And (player[arg0]\Field33 = $00))) <> 0) Then
        If ((networkserver\Field15 Or (networkserver\Field23 = $00)) <> 0) Then
            For local1 = Each items
                If (((local1\Field22 = arg0) And (local1\Field22 <> $00)) <> 0) Then
                    playerdropitem(local1)
                EndIf
            Next
        EndIf
        createrolecorpse(player[arg0]\Field73, entityx(player[arg0]\Field13, $00), entityy(player[arg0]\Field13, $00), entityz(player[arg0]\Field13, $00), entityyaw(player[arg0]\Field13, $00), player[arg0]\Field92, $00, $00, $00, $00)
        player[arg0]\Field73 = player[arg0]\Field51
        local0 = $01
        If (networkserver\Field18 = $01) Then
            Select player[arg0]\Field51
                Case haos_model,ntf_model
                    If (rand($03, $01) = $01) Then
                        giveitem("FN P90", "p90", arg0)
                    Else
                        giveitem("MP5-SD", "mp5sd", arg0)
                    EndIf
                    giveitem("USP Tactical", "usp", arg0)
                    giveitem("Key Card Omni", "key6", arg0)
                    giveitem("Radio Transceiver", "radio", arg0)
                    giveitem("Grenade", "grenade", arg0)
                    giveitem("Grenade", "grenade", arg0)
                    If (rand($03, $01) = $01) Then
                        giveitem("First Aid Kit", "firstaid", arg0)
                    EndIf
                    If (rand($04, $01) = $01) Then
                        giveitem("Rocket Launcher", "rpg", arg0)
                    EndIf
                Case guard_model
                    If (rand($03, $01) = $01) Then
                        giveitem("FN P90", "p90", arg0)
                    Else
                        giveitem("MP5-SD", "mp5sd", arg0)
                    EndIf
                    giveitem("USP Tactical", "usp", arg0)
                    giveitem("Level 5 Key Card", "key5", arg0)
                    giveitem("Radio Transceiver", "radio", arg0)
                    giveitem("Grenade", "grenade", arg0)
                    If (rand($03, $01) = $01) Then
                        giveitem("First Aid Kit", "firstaid", arg0)
                    EndIf
                    If (rand($08, $01) = $01) Then
                        giveitem("Rocket Launcher", "rpg", arg0)
                    EndIf
                Case scientist_model,model_clerk
                    giveitem("Level 2 Key Card", "key2", arg0)
                Case janitor_model,worker_model
                    giveitem("Level 1 Key Card", "key1", arg0)
                Default
                    If (multiplayer_isascp(player[arg0]\Field51) <> 0) Then
                        giveitem("Level 5 Key Card", "key5", arg0)
                    EndIf
            End Select
        EndIf
    EndIf
    If ((((arg1 <> player[arg0]\Field50) And (player[arg0]\Field51 = classd_model)) And (player[arg0]\Field40 = $00)) <> 0) Then
        player[arg0]\Field50 = arg1
        local0 = $01
    EndIf
    If (arg2 <> player[arg0]\Field40) Then
        player[arg0]\Field40 = arg2
        local0 = $01
    EndIf
    If (local0 <> 0) Then
        multiplayer_initplayer(arg0)
    EndIf
    player[arg0]\Field32 = readbool(arg3, $03)
    player[arg0]\Field33 = readbool(arg3, $04)
    Return $00
End Function
