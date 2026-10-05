Function multiplayer_initsettingsforplayer%(arg0.players, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1.items
    Local local2%
    Local local3.players
    Local local5%
    arg0\Field41 = readbool(arg4, $00)
    arg0\Field102 = readbool(arg4, $01)
    arg0\Field33 = (Float ((arg0\Field53 >= $05) And (arg0\Field53 <= $0A)))
    If (mainmenuopen <> 0) Then
        Return $00
    EndIf
    local0 = $00
    If (((arg1 <> arg0\Field49) Or ((readbool(arg4, $04) = $01) And (arg0\Field31 = $00))) <> 0) Then
        If ((networkserver\Field12 Or (networkserver\Field52\Field12 = $00)) <> 0) Then
            For local1 = Each items
                If (((local1\Field22 = arg0\Field0) And (local1\Field22 <> $00)) <> 0) Then
                    playerdropitem(local1)
                EndIf
            Next
        EndIf
        local2 = (arg0\Field49 > $00)
        If (((arg1 = model_zombie) And (arg0\Field49 <> model_zombie)) <> 0) Then
            local2 = $00
        EndIf
        If (((arg1 = model_035) And (arg0\Field49 <> model_035)) <> 0) Then
            local2 = $00
        EndIf
        If (local2 <> 0) Then
            createrolecorpse(arg0\Field49, entityx(arg0\Field13, $00), entityy(arg0\Field13, $00), entityz(arg0\Field13, $00), entityyaw(arg0\Field13, $00), arg0\Field90, $00, $00, $00, $00)
        ElseIf (arg0\Field49 <> model_035) Then
            For local3 = Each players
                If (local3\Field49 = model_049) Then
                    If (local3\Field12 <> $00) Then
                        If (4.0 > entitydistance(local3\Field13, arg0\Field13)) Then
                            local3\Field54 = $0F
                            setanimtime(local3\Field12, 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
        arg0\Field49 = arg1
        local0 = $01
        If (arg0\Field49 = model_939) Then
            entityradius(arg0\Field13, 0.3, 0.0)
        Else
            entityradius(arg0\Field13, 0.15, 0.3)
        EndIf
        If (networkserver\Field15 = $01) Then
            Select arg1
                Case haos_model,ntf_model
                    If (rand($03, $01) = $01) Then
                        giveitem("FN P90", "p90", arg0\Field0)
                    Else
                        giveitem("MP5-SD", "mp5sd", arg0\Field0)
                    EndIf
                    giveitem("USP Tactical", "usp", arg0\Field0)
                    giveitem("Key Card Omni", "key6", arg0\Field0)
                    giveitem("Radio Transceiver", "radio", arg0\Field0)
                    giveitem("Grenade", "grenade", arg0\Field0)
                    giveitem("Grenade", "grenade", arg0\Field0)
                    giveitem("Strange Bottle", "veryfinefirstaid", arg0\Field0)
                    giveitem("Night Vision Goggles", "supernv", arg0\Field0)
                    If (rand($EA, $01) = $01) Then
                        giveitem("Rocket Launcher", "rpg", arg0\Field0)
                    EndIf
                Case guard_model
                    If (rand($03, $01) = $01) Then
                        giveitem("FN P90", "p90", arg0\Field0)
                    Else
                        giveitem("MP5-SD", "mp5sd", arg0\Field0)
                    EndIf
                    giveitem("USP Tactical", "usp", arg0\Field0)
                    giveitem("Level 5 Key Card", "key5", arg0\Field0)
                    giveitem("Radio Transceiver", "radio", arg0\Field0)
                    giveitem("Grenade", "grenade", arg0\Field0)
                    giveitem("Strange Bottle", "veryfinefirstaid", arg0\Field0)
                    If (rand($EA, $01) = $01) Then
                        giveitem("Rocket Launcher", "rpg", arg0\Field0)
                    EndIf
                Case scientist_model,model_clerk
                    giveitem("Level 2 Key Card", "key2", arg0\Field0)
                Case janitor_model,worker_model
                    giveitem("Level 1 Key Card", "key1", arg0\Field0)
                Default
                    If (multiplayer_isascp(arg1) <> 0) Then
                        giveitem("Level 5 Key Card", "key5", arg0\Field0)
                    EndIf
            End Select
        EndIf
    EndIf
    If ((((arg2 <> arg0\Field48) And (arg1 = classd_model)) And (arg0\Field38 = $00)) <> 0) Then
        arg0\Field48 = arg2
        local0 = $01
    EndIf
    If (arg3 <> arg0\Field38) Then
        arg0\Field38 = arg3
        local0 = $01
    EndIf
    If (local0 <> 0) Then
        multiplayer_initplayer(arg0\Field0)
    EndIf
    local5 = readbool(arg4, $06)
    If (((local5 = $01) And (arg0\Field50 = $00)) <> 0) Then
        playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement.ogg"))
    EndIf
    If (((local5 = $00) And (arg0\Field50 = $01)) <> 0) Then
        playsound_strict(loadtempsound("GFX\multiplayer\game\sounds\Announcement2.ogg"))
    EndIf
    arg0\Field50 = local5
    arg0\Field30 = readbool(arg4, $03)
    arg0\Field31 = readbool(arg4, $04)
    If (((arg0\Field93 <> "0") And (arg0\Field104 = $00)) <> 0) Then
        steam_setplayedwith(arg0\Field94, arg0\Field95)
        arg0\Field104 = $01
    EndIf
    If (5.0 <= distance3(arg0\Field1, arg0\Field2, arg0\Field3, entityx(arg0\Field13, $00), entityy(arg0\Field13, $00), entityz(arg0\Field13, $00))) Then
        positionentity(arg0\Field13, arg0\Field1, (arg0\Field2 + 0.32), arg0\Field3, $00)
        resetentity(arg0\Field13)
    EndIf
    Return $00
End Function
