Function executeconsolecommand%(arg0$, arg1%, arg2%)
    Local local0$
    Local local3%
    Local local4.decals
    Local local5%
    Local local6.events
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    Local local12.items
    Local local14.rooms
    Local local15%
    Local local16.players
    Local local17%
    Local local18.itemtemplates
    Local local20.npcs
    Local local21%
    Local local22%
    Local local23%
    Local local27.sound
    Local local28.events
    Local local29.snd3d
    Local local30$
    Local local31$
    Local local34$
    If (instr(arg0, " ", $01) > $00) Then
        local0 = lower(left(arg0, (instr(arg0, " ", $01) - $01)))
    Else
        local0 = lower(arg0)
    EndIf
    If (arg2 <> 0) Then
        If (udp_getstream() <> 0) Then
            udp_bytestreamwritechar($77)
            udp_bytestreamwriteline(arg0)
            udp_setmicrobyte($77)
        EndIf
    EndIf
    Select lower(local0)
        Case "help"
            If (instr(arg0, " ", $01) <> $00) Then
                local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Else
                local0 = ""
            EndIf
            consoler = $00
            consoleg = $FF
            consoleb = $FF
            Select lower(local0)
                Case "1",""
                    createconsolemsg("LIST OF COMMANDS - PAGE 1/3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- status", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- camerapick", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- ending", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noclipspeed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- injure [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- infect [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- spawnitem [item name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- wireframe", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 173speed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 106speed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 173state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 106state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg((((("Use " + chr($22)) + "help 2/3") + chr($22)) + " to find more commands."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg((((("Use " + chr($22)) + "help [command name]") + chr($22)) + " to get more information about a command."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "2"
                    createconsolemsg("LIST OF COMMANDS - PAGE 2/3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- spawn [npc type] [state]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- reset096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- halloween", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- sanic", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- scp-420-j", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- godmode", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- showfps", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 096state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- debughud", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- camerafog [near] [far]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- gamma [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- infinitestamina", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg((((("Use " + chr($22)) + "help [command name]") + chr($22)) + " to get more information about a command."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "3"
                    createconsolemsg("- playmusic [clip + .wav/.ogg]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- notarget", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- unlockexits", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "asd"
                    createconsolemsg("HELP - asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Actives godmode, noclip, wireframe and", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("sets fog distance to 20 near, 30 far", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "camerafog"
                    createconsolemsg("HELP - camerafog", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Sets the draw distance of the fog.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("The fog begins generating at 'CameraFogNear' units", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("away from the camera and becomes completely opaque", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("at 'CameraFogFar' units away from the camera.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Example: camerafog 20 40", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "gamma"
                    createconsolemsg("HELP - gamma", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Sets the gamma correction.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Should be set to a value between 0.0 and 2.0.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Default is 1.0.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "noclip","fly"
                    createconsolemsg("HELP - noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Toggles noclip, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Allows the camera to move in any direction while", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("bypassing collision.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "godmode","god"
                    createconsolemsg("HELP - godmode", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Toggles godmode, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Prevents player death under normal circumstances.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "wireframe"
                    createconsolemsg("HELP - wireframe", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Toggles wireframe, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Allows only the edges of geometry to be rendered,", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("making everything else transparent.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawnitem"
                    createconsolemsg("HELP - spawnitem", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Spawns an item at the player's location.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Any name that can appear in your inventory", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("is a valid parameter.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Example: spawnitem Key Card Omni", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawn"
                    createconsolemsg("HELP - spawn", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Spawns an NPC at the player's location.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Valid parameters are:", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("008zombie / 049 / 049-2 / 066 / 096 / 106 / 173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("/ 178-1 / 372 / 513-1 / 966 / 1499-1 / class-d", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("/ guard / mtf / apache / tentacle", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "revive","undead","resurrect"
                    createconsolemsg("HELP - revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Resets the player's death timer after the dying", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("animation triggers.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Does not affect injury, blood loss", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("or 008 infection values.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "teleport"
                    createconsolemsg("HELP - teleport", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Teleports the player to the first instance", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("of the specified room. Any room that appears", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("in rooms.ini is a valid parameter.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "stopsound","stfu"
                    createconsolemsg("HELP - stopsound", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Stops all currently playing sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "camerapick"
                    createconsolemsg("HELP - camerapick", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Prints the texture name and coordinates of", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("the model the camera is pointing at.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "status"
                    createconsolemsg("HELP - status", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Prints player, camera, and room information.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "weed","scp-420-j","420"
                    createconsolemsg("HELP - 420", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Generates dank memes.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "playmusic"
                    createconsolemsg("HELP - playmusic", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Will play tracks in .ogg/.wav format", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg((((("from " + chr($22)) + "SFX\Music\Custom\") + chr($22)) + "."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Default
                    createconsolemsg("There is no help available for that command.", $FF, $96, $00, $00)
            End Select
        Case "decal"
            local3 = createpivot($00)
            positionentity(local3, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local3, 90.0, 0.0, 0.0, $00)
            entitypick(local3, 0.3)
            local4 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            local4\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
            entityalpha(local4\Field0, 1.0)
            scalesprite(local4\Field0, local4\Field2, local4\Field2)
            local5 = playsound_strict(dripsfx(rand($00, $02)))
            channelvolume(local5, (rnd(0.0, 0.8) * sfxvolume))
            channelpitch(local5, rand($4E20, $7530))
            freeentity(local3)
            multiplayer_writedecal(local4, $01, $01)
        Case "ambient"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            shouldplay = (Int local0)
        Case "asd"
            wireframe($01)
            wireframestate = $01
            godmode = $01
            noclip = $01
            camerafognear = 15.0
            camerafogfar = 20.0
        Case "status"
            consoler = $00
            consoleg = $FF
            consoleb = $00
            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("Status: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("Coordinates: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("    - collider: " + (Str entityx(collider, $00))) + ", ") + (Str entityy(collider, $00))) + ", ") + (Str entityz(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("    - camera: " + (Str entityx(camera, $00))) + ", ") + (Str entityy(camera, $00))) + ", ") + (Str entityz(camera, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("Rotation: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("    - collider: " + (Str entitypitch(collider, $00))) + ", ") + (Str entityyaw(collider, $00))) + ", ") + (Str entityroll(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("    - camera: " + (Str entitypitch(camera, $00))) + ", ") + (Str entityyaw(camera, $00))) + ", ") + (Str entityroll(camera, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Room: " + playerroom\Field7\Field11), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            For local6 = Each events
                If (local6\Field1 = playerroom) Then
                    createconsolemsg(("Room event: " + local6\Field0), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("-    state: " + (Str local6\Field2)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("-    state2: " + (Str local6\Field3)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("-    state3: " + (Str local6\Field4)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Exit
                EndIf
            Next
            createconsolemsg(((("Room coordinates: " + (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Stamina: " + (Str stamina)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Death timer: " + (Str killtimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Blinktimer: " + (Str blinktimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Injuries: " + (Str injuries)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Bloodloss: " + (Str bloodloss)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "camerapick"
            consoler = $00
            consoleg = $FF
            consoleb = $00
            local7 = camerapick(camera, (Float (graphicwidth Sar $01)), (Float (graphicheight Sar $01)))
            If (local7 = $00) Then
                createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                createconsolemsg("No entity  picked", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                createconsolemsg("Picked entity:", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                local8 = getsurface(local7, $01)
                local9 = getsurfacebrush(local8)
                local10 = getbrushtexture(local9, $00)
                local11 = strippath(texturename(local10))
                createconsolemsg(("Texture name: " + local11), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                createconsolemsg(((((("Coordinates: " + (Str entityx(local7, $00))) + ", ") + (Str entityy(local7, $00))) + ", ") + (Str entityz(local7, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "ending"
            selectedending = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            killtimer = -0.1
        Case "noclipspeed"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            noclipspeed = (Float local0)
        Case "injure"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            injuries = (Float local0)
        Case "infect"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            infect = (Float local0)
        Case "hidedistance"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            hidedistance = (Float local0)
        Case "heal"
            injuries = 0.0
            bloodloss = 0.0
        Case "freeitems"
            For local12 = Each items
                removeitem(local12, $01)
            Next
        Case "role"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            If ((((Int local0) >= $00) And ((Int local0) <= (last_breach_type - $01))) <> 0) Then
                multiplayer_requestrole((Int local0))
            EndIf
        Case "daun"
            changermesh(playerroom, "GFX\map\room106_opt.rmesh")
        Case "teleport"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "895","scp-895"
                    local0 = "coffin"
                Case "scp-914"
                    local0 = "914"
                Case "offices","office"
                    local0 = "room2offices"
            End Select
            For local14 = Each rooms
                If (local14\Field7\Field11 = local0) Then
                    positionentity(collider, entityx(local14\Field2, $00), (entityy(local14\Field2, $00) + 0.7), entityz(local14\Field2, $00), $00)
                    resetentity(collider)
                    updatedoors()
                    updaterooms()
                    For local12 = Each items
                        local12\Field12 = 0.0
                    Next
                    playerroom = local14
                    Exit
                EndIf
            Next
            local15 = $00
            For local16 = Each players
                If (local16\Field0 <> networkserver\Field28) Then
                    If (lower(local16\Field24) = lower(local0)) Then
                        For local14 = Each rooms
                            If (local14\Field7\Field11 = local16\Field46) Then
                                positionentity(collider, entityx(local16\Field13, $00), entityy(local16\Field13, $00), entityz(local16\Field13, $00), $00)
                                resetentity(collider)
                                updatedoors()
                                updaterooms()
                                For local12 = Each items
                                    local12\Field12 = 0.0
                                Next
                                playerroom = local14
                                local15 = $01
                                Exit
                            EndIf
                        Next
                        If (local15 = $00) Then
                            positionentity(collider, entityx(local16\Field13, $00), entityy(local16\Field13, $00), entityz(local16\Field13, $00), $00)
                            resetentity(collider)
                            updatedoors()
                            updaterooms()
                            For local12 = Each items
                                local12\Field12 = 0.0
                            Next
                            local15 = $01
                        EndIf
                    EndIf
                EndIf
            Next
            If (((playerroom\Field7\Field11 <> local0) And (local15 = $00)) <> 0) Then
                createconsolemsg("Room or player not found.", $FF, $96, $00, $00)
            EndIf
        Case "spawnitem"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            local17 = $00
            For local18 = Each itemtemplates
                If (lower(local18\Field1) = local0) Then
                    local17 = $01
                    Exit
                ElseIf (lower(local18\Field2) = local0) Then
                    local17 = $01
                    Exit
                EndIf
            Next
            If (local17 = $01) Then
                If (networkserver\Field18 <> 0) Then
                    gameload = $01
                    createconsolemsg((local18\Field1 + " spawned."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    local12 = createitem(local18\Field1, local18\Field2, entityx(collider, $00), (entityy(camera, $01) - 0.1), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
                    entitytype(local12\Field1, $03, $00)
                    gameload = $00
                EndIf
            EndIf
            If (local17 = $00) Then
                createconsolemsg("Item not found.", $FF, $96, $00, $00)
            EndIf
        Case "wireframe"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    wireframestate = $01
                Case "off","0","false"
                    wireframestate = $00
                Default
                    wireframestate = (wireframestate = $00)
            End Select
            If (wireframestate <> 0) Then
                createconsolemsg("WIREFRAME ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("WIREFRAME OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            wireframe(wireframestate)
        Case "173speed"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            curr173\Field21 = (Float local0)
            createconsolemsg(("173's speed set to " + local0), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "106speed"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            curr106\Field21 = (Float local0)
            createconsolemsg(("106's speed set to " + local0), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "173state"
            createconsolemsg("SCP-173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("Position: " + (Str entityx(curr173\Field0, $00))) + ", ") + (Str entityy(curr173\Field0, $00))) + ", ") + (Str entityz(curr173\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Idle: " + (Str curr173\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("State: " + (Str curr173\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "106state"
            createconsolemsg("SCP-106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(((((("Position: " + (Str entityx(curr106\Field0, $00))) + ", ") + (Str entityy(curr106\Field0, $00))) + ", ") + (Str entityz(curr106\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("Idle: " + (Str curr106\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(("State: " + (Str curr106\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "reset096"
            For local20 = Each npcs
                If (local20\Field5 = $09) Then
                    local20\Field9 = 0.0
                    stopstream_strict(local20\Field17)
                    local20\Field17 = $00
                    If (local20\Field20 <> $00) Then
                        stopstream_strict(local20\Field20)
                        local20\Field20 = $00
                    EndIf
                    Exit
                EndIf
            Next
        Case "disable173"
            curr173\Field24 = 3.0
            hideentity(curr173\Field0)
            hideentity(curr173\Field4)
        Case "enable173"
            curr173\Field24 = 0.0
            showentity(curr173\Field0)
            showentity(curr173\Field4)
        Case "disable106"
            curr106\Field24 = 1.0
            curr106\Field9 = 200000.0
            contained106 = $01
        Case "enable106"
            curr106\Field24 = 0.0
            contained106 = $00
            showentity(curr106\Field4)
            showentity(curr106\Field0)
        Case "halloween"
            halloweentex = (halloweentex = $00)
            If (halloweentex <> 0) Then
                local21 = loadtexture_strict("GFX\npcs\173h.pt", $01)
                entitytexture(curr173\Field0, local21, $00, $00)
                freetexture(local21)
                createconsolemsg("173 JACK-O-LANTERN ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                local22 = loadtexture_strict("GFX\npcs\173texture.jpg", $01)
                entitytexture(curr173\Field0, local22, $00, $00)
                freetexture(local22)
                createconsolemsg("173 JACK-O-LANTERN OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "sanic"
            superman = (superman = $00)
            If (superman = $01) Then
                createconsolemsg("GOTTA GO FAST", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("WHOA SLOW DOWN", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "scp-420-j","420","weed"
            If (networkserver\Field18 <> 0) Then
                For local23 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local12 = createitem("Some SCP-420-J", "420", ((cos((18.0 * (Float local23))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local23))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00, $01)
                    Else
                        local12 = createitem("Joint", "420s", ((cos((18.0 * (Float local23))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local23))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00, $01)
                    EndIf
                    entitytype(local12\Field1, $03, $00)
                Next
                playsound_strict(loadtempsound("SFX\Music\420J.ogg"))
                multiplayer_writetempsound("SFX\Music\420J.ogg", 0.0, 0.0, 0.0, 20.0, 1.0)
            EndIf
        Case "godmode","god"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    godmode = $01
                Case "off","0","false"
                    godmode = $00
                Default
                    godmode = (godmode = $00)
            End Select
            If (godmode <> 0) Then
                createconsolemsg("GODMODE ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("GODMODE OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "revive","undead","resurrect"
            stamina = 60.0
            staminaeffect = 1.0
            staminaeffecttimer = 0.0
            For local23 = $00 To $05 Step $01
                scp1025state[local23] = 0.0
            Next
            bloodloss = 0.0
            superman = $00
            supermantimer = 0.0
            dropspeed = -0.1
            headdropspeed = 0.0
            shake = 0.0
            currspeed = 0.0
            heartbeatvolume = 0.0
            infect = 0.0
            camerashake = 0.0
            shake = 0.0
            lightflash = 0.0
            blurtimer = 0.0
            falltimer = 0.0
            menuopen = $00
            godmode = $00
            noclip = $00
            showentity(collider)
            positionentity(collider, entityx(collider, $00), (entityy(collider, $00) + 1.0), entityz(collider, $00), $00)
            resetentity(collider)
            killtimer = 0.0
            killanim = $00
            myplayer\Field33 = $00
            eyeirritation = 0.0
            hideentity(head)
            If (getscripts() <> 0) Then
                public_inqueue($04, $01)
            EndIf
        Case "noclip","fly"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    noclip = $01
                    playable = $01
                Case "off","0","false"
                    noclip = $00
                    rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                    rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                Default
                    noclip = (noclip = $00)
                    If (noclip = $00) Then
                        rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                        rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                    Else
                        playable = $01
                    EndIf
            End Select
            If (noclip <> 0) Then
                createconsolemsg("NOCLIP ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("NOCLIP OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            dropspeed = 0.0
        Case "showfps"
            showfps = (showfps = $00)
            createconsolemsg(("ShowFPS: " + (Str showfps)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "096state"
            For local20 = Each npcs
                If (local20\Field5 = $09) Then
                    createconsolemsg("SCP-096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("Position: " + (Str entityx(local20\Field0, $00))) + ", ") + (Str entityy(local20\Field0, $00))) + ", ") + (Str entityz(local20\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Idle: " + (Str local20\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("State: " + (Str local20\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Exit
                EndIf
            Next
            createconsolemsg("SCP-096 has not spawned.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "debughud"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    debughud = $01
                Case "off","0","false"
                    debughud = $00
                Default
                    debughud = (debughud = $00)
            End Select
            If (debughud <> 0) Then
                createconsolemsg("Debug Mode On", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("Debug Mode Off", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "vomit"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            vomittimer = (Float (Int local0))
            createconsolemsg(("Vomit timer set to " + (Str vomittimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "stopsound","stfu"
            For local27 = Each sound
                For local23 = $00 To $1F Step $01
                    If (local27\Field2[local23] <> $00) Then
                        stopchannel(local27\Field2[local23])
                    EndIf
                Next
            Next
            If (((udp_getstream() = $00) Or networkserver\Field18) <> 0) Then
                For local28 = Each events
                    If (local28\Field0 = "alarm") Then
                        If (local28\Field1\Field32[$00] <> Null) Then
                            removenpc(local28\Field1\Field32[$00], $00)
                        EndIf
                        If (local28\Field1\Field32[$01] <> Null) Then
                            removenpc(local28\Field1\Field32[$01], $00)
                        EndIf
                        If (local28\Field1\Field32[$02] <> Null) Then
                            removenpc(local28\Field1\Field32[$02], $00)
                        EndIf
                        positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                        resetentity(curr173\Field4)
                        showentity(curr173\Field0)
                        removeevent(local28)
                        Exit
                    EndIf
                Next
                createconsolemsg("Stopped all sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                multiplayer_send($2A, $FFFFFFFF, $FFFFFFFF)
            EndIf
            For local29 = Each snd3d
                If (local29\Field0 = $00) Then
                    stopchannel(local29\Field2)
                    If (local29\Field6 <> 0) Then
                        freeentity(local29\Field5)
                    EndIf
                    Delete local29
                Else
                    fsound_stopsound(local29\Field2)
                    fsound_stream_stop(local29\Field1)
                    fsound_stream_close(local29\Field1)
                    Delete local29
                EndIf
            Next
        Case "camerafog"
            local30 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            camerafognear = (Float left(local30, (len(local30) - instr(local30, " ", $01))))
            camerafogfar = (Float right(local30, (len(local30) - instr(local30, " ", $01))))
            createconsolemsg(((("Near set to: " + (Str camerafognear)) + ", far set to: ") + (Str camerafogfar)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            If (hidedistance < camerafogfar) Then
                hideentity(fog)
            Else
                showentity(fog)
            EndIf
        Case "gamma"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            screengamma = (Float (Int local0))
            createconsolemsg(("Gamma set to " + (Str screengamma)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "spawn"
            local30 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            local0 = piece(local30, $01, " ")
            local31 = piece(local30, $02, " ")
            If (local0 <> local31) Then
                console_spawnnpc(local0, local31, $00)
            Else
                console_spawnnpc(local0, "", $00)
            EndIf
        Case "infinitestamina","infstam"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    infinitestamina = $01
                Case "off","0","false"
                    infinitestamina = $00
                Default
                    infinitestamina = (infinitestamina = $00)
            End Select
            If (infinitestamina <> 0) Then
                createconsolemsg("INFINITE STAMINA ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("INFINITE STAMINA OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "unlockexits"
            For local28 = Each events
                If (local28\Field0 = "gateaentrance") Then
                    local28\Field4 = 1.0
                    local28\Field1\Field29[$01]\Field5 = $01
                ElseIf (local28\Field0 = "exit1") Then
                    local28\Field4 = 1.0
                    local28\Field1\Field29[$04]\Field5 = $01
                EndIf
            Next
            createconsolemsg("Gate A and B are now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            remotedooron = $01
            multiplayer_send($12, $FFFFFFFF, $FFFFFFFF)
        Case "kill","suicide"
            Select rand($04, $01)
                Case $01
                    deathmsg = "[REDACTED]"
                Case $02
                    deathmsg = "Subject D-9341 found dead in Sector [REDACTED]. "
                    deathmsg = (deathmsg + "The subject appears to have attained no physical damage, and there is no visible indication as to what killed him. ")
                    deathmsg = (deathmsg + "Body was sent for autopsy.")
                Case $03
                    deathmsg = "EXCP_ACCESS_VIOLATION"
                Case $04
                    deathmsg = "Subject D-9341 found dead in Sector [REDACTED]. "
                    deathmsg = (((((deathmsg + "The subject appears to have scribbled the letters ") + chr($22)) + "kys") + chr($22)) + " in his own blood beside him. ")
                    deathmsg = (deathmsg + "No other signs of physical trauma or struggle can be observed. Body was sent for autopsy.")
            End Select
            kill("decided to gnaw their veins", $00)
        Case "playmusic"
            If (instr(arg0, " ", $01) <> $00) Then
                local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Else
                local0 = ""
            EndIf
            If (local0 <> "") Then
                playcustommusic = $01
                If (custommusic <> $00) Then
                    freesound_strict(custommusic)
                    custommusic = $00
                EndIf
                If (musicchn <> $00) Then
                    stopchannel(musicchn)
                EndIf
                custommusic = loadsound_strict(("SFX\Music\Custom\" + local0))
                If (custommusic = $00) Then
                    playcustommusic = $00
                EndIf
            Else
                playcustommusic = $00
                If (custommusic <> $00) Then
                    freesound_strict(custommusic)
                    custommusic = $00
                EndIf
                If (musicchn <> $00) Then
                    stopchannel(musicchn)
                EndIf
            EndIf
        Case "tp"
            For local20 = Each npcs
                If (local20\Field5 = $08) Then
                    If (local20\Field47 = Null) Then
                        positionentity(collider, entityx(local20\Field4, $00), (entityy(local20\Field4, $00) + 5.0), entityz(local20\Field4, $00), $00)
                        resetentity(collider)
                        Exit
                    EndIf
                EndIf
            Next
        Case "tele"
            local30 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            local0 = piece(local30, $01, " ")
            local31 = piece(local30, $02, " ")
            local34 = piece(local30, $03, " ")
            positionentity(collider, (Float local0), (Float local31), (Float local34), $00)
            positionentity(camera, (Float local0), (Float local31), (Float local34), $00)
            resetentity(collider)
            resetentity(camera)
            createconsolemsg(((((("Teleported to coordinates (X|Y|Z): " + (Str entityx(collider, $00))) + "|") + (Str entityy(collider, $00))) + "|") + (Str entityz(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "notarget"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Select local0
                Case "on","1","true"
                    notarget = $01
                Case "off","0","false"
                    notarget = $00
                Default
                    notarget = (notarget = $00)
            End Select
            If (notarget = $00) Then
                createconsolemsg("NOTARGET OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg("NOTARGET ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            multiplayer_send($6E, $FFFFFFFF, $FFFFFFFF)
        Case "spawnradio"
            local12 = createitem("Radio Transceiver", "fineradio", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
            entitytype(local12\Field1, $03, $00)
            local12\Field13 = 101.0
        Case "spawnnvg"
            local12 = createitem("Night Vision Goggles", "nvgoggles", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
            entitytype(local12\Field1, $03, $00)
            local12\Field13 = 1000.0
        Case "spawnpumpkin","pumpkin"
            createconsolemsg("What pumpkin?", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "spawnnav"
            local12 = createitem("S-NAV Navigator Ultimate", "nav", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00, $01)
            entitytype(local12\Field1, $03, $00)
            local12\Field13 = 101.0
        Case "teleport173"
            positionentity(curr173\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00), $00)
            resetentity(curr173\Field4)
        Case "spawnparticles"
            If (instr(arg0, " ", $01) <> $00) Then
                local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Else
                local0 = ""
            EndIf
            If ((((Int local0) > $FFFFFFFF) And ((Int local0) <= $01)) <> 0) Then
                setemitter(collider, particleeffect[(Int local0)], $00, $00)
                createconsolemsg((("Spawned particle emitter with ID " + (Str (Int local0))) + " at player's position."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg((("Particle emitter with ID " + (Str (Int local0))) + " not found."), $FF, $96, $00, $00)
            EndIf
        Case "giveachievement"
            If (instr(arg0, " ", $01) <> $00) Then
                local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            Else
                local0 = ""
            EndIf
            If ((((Int local0) >= $00) And ((Int local0) < $25)) <> 0) Then
                achievements((Int local0)) = $01
                createconsolemsg((("Achievemt " + achievementstrings((Int local0))) + " unlocked."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg((("Achievement with ID " + (Str (Int local0))) + " doesn't exist."), $FF, $96, $00, $00)
            EndIf
        Case "427state"
            local0 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            i_427\Field1 = ((Float local0) * 70.0)
        Case "teleport106"
            curr106\Field9 = 0.0
            curr106\Field24 = 0.0
        Case "setblinkeffect"
            local30 = lower(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
            blinkeffect = (Float left(local30, (len(local30) - instr(local30, " ", $01))))
            blinkeffecttimer = (Float right(local30, (len(local30) - instr(local30, " ", $01))))
            createconsolemsg(((("Set BlinkEffect to: " + (Str blinkeffect)) + "and BlinkEffect timer: ") + (Str blinkeffecttimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "jorge"
            createconsolemsg(((((((((((((((((((((((((((((chr($4A) + chr($4F)) + chr($52)) + chr($47)) + chr($45)) + chr($20)) + chr($48)) + chr($41)) + chr($53)) + chr($20)) + chr($42)) + chr($45)) + chr($45)) + chr($4E)) + chr($20)) + chr($45)) + chr($58)) + chr($50)) + chr($45)) + chr($43)) + chr($54)) + chr($49)) + chr($4E)) + chr($47)) + chr($20)) + chr($59)) + chr($4F)) + chr($55)) + chr($2E)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Default
            If (arg1 <> 0) Then
                createconsolemsg("Command not found.", $FF, $00, $00, $00)
            EndIf
            Return $00
    End Select
    usedconsole = $01
    Return $00
End Function
