Function cfg_findcmd%(arg0$)
    Local local0$
    Local local3%
    Local local4.scriptsthread
    local0 = trim(right(arg0, (len(arg0) - instr(arg0, " ", $01))))
    arg0 = trim(left(arg0, instr(arg0, " ", $01)))
    Select arg0
        Case "maxiconnfromip"
            server\Field86 = (Int local0)
        Case "globalblinktimer"
            server\Field83 = (Int local0)
        Case "globalblinktimerinterval"
            server\Field84 = (Int local0)
        Case "max_receive_bytes"
        Case "recvbuffermult"
            server\Field87 = (Int max((Float (Int local0)), 1.0))
        Case "bind"
            server\Field80 = local0
        Case "intercom_timeout"
            server\Field77 = (Int local0)
        Case "intercom_timeout"
            server\Field78 = (Int local0)
        Case "intercom_enable"
            local0 = (Str cfg_findbool(local0))
            server\Field79 = ($01 - (Int local0))
        Case "speedhack_rate"
            server\Field74 = (Float local0)
        Case "noclipanticheat"
            local0 = (Str cfg_findbool(local0))
            server\Field73 = (Int local0)
        Case "camerashakeondamage"
            local0 = (Str cfg_findbool(local0))
            server\Field72 = (Int local0)
        Case "centralservertcprequest"
            local0 = (Str cfg_findbool(local0))
            server\Field70 = (Int local0)
        Case "centralserver"
            local0 = (Str cfg_findbool(local0))
            server\Field69 = (Int local0)
        Case "disabletimestamp"
            local0 = (Str cfg_findbool(local0))
            server\Field68 = (Int local0)
        Case "roundslimitperstart"
            server\Field55 = (Int local0)
        Case "resettimerafterconnect"
            local0 = (Str cfg_findbool(local0))
            server\Field54 = (Int local0)
        Case "minplayerstostart"
            server\Field53 = (Int local0)
        Case "voice_quality"
            server\Field32 = (Int local0)
        Case "keepinventory"
            local0 = (Str cfg_findbool(local0))
            server\Field31 = (Int local0)
        Case "rconpassword"
            server\Field28 = local0
        Case "difficulty"
            server\Field26 = lower(local0)
            server\Field27 = server\Field26
            selecteddifficulty = difficulties(getdiff(server\Field26))
        Case "breach_onlydeathmatch"
            local0 = (Str cfg_findbool(local0))
            server\Field29 = (Int local0)
        Case "disableauthkey"
            local0 = (Str cfg_findbool(local0))
            server\Field65 = ((Int local0) = $00)
        Case "breach"
            local0 = (Str cfg_findbool(local0))
            server\Field21 = (Int local0)
        Case "breachtime"
            server\Field22 = (Int local0)
        Case "gravity"
            server\Field20 = (Float local0)
        Case "jumpmode"
            local0 = (Str cfg_findbool(local0))
            server\Field19 = (Int local0)
        Case "maxplayers"
            server\Field18 = (Int local0)
        Case "eventprob"
            server\Field15 = (Float local0)
        Case "password"
            server\Field14 = local0
        Case "timeout"
            server\Field13 = (Int local0)
        Case "nocheat","nocheat mode"
            local0 = (Str cfg_findbool(local0))
            server\Field2 = (Int local0)
        Case "hostname"
            server\Field5 = local0
        Case "tickrate"
            server\Field3 = (Int local0)
            Select server\Field3
                Case $80,$40
                Default
                    server\Field3 = $40
            End Select
            server\Field4 = gettickratedelay()
        Case "port"
            server\Field1 = (Str (Int local0))
        Case "mapsize"
            server\Field52 = (Int local0)
        Case "mapseed"
            server\Field7 = local0
        Case "description"
            server\Field42 = local0
        Case "weburl"
            server\Field44 = local0
        Case "menuhtml"
            server\Field75 = local0
        Case "restartmenuhtml"
            server\Field76 = local0
        Case "gamestate"
            server\Field43 = local0
        Case "savegameafterexit"
            server\Field34 = (Int local0)
        Case "introenabled"
            local0 = (Str cfg_findbool(local0))
            server\Field8 = (Int local0)
        Case "voice"
            local0 = (Str cfg_findbool(local0))
            server\Field10 = (Int local0)
        Case "argumentsstacksize"
            se_arguments_stack_size = (Int local0)
        Case "transientstacksize"
            se_transient_stack_size = (Int local0)
        Case "stacksize"
            se_arguments_stack_size = $20
            se_transient_stack_size = (Int local0)
        Case "luascript"
            se_executefunction($01, $00)
            For local3 = $01 To (countchar(local0, " ") + $01) Step $01
                local4 = (New scriptsthread)
                local4\Field1 = piece(local0, local3, " ")
                If (se_isvalidscript(local4\Field1, ".lua") <> 0) Then
                    local4\Field3 = slua_load_file(local4\Field1)
                    If (local4\Field3 <> $00) Then
                        skynet_onload()
                    EndIf
                EndIf
            Next
        Case "script"
            se_init()
            For local3 = $01 To (countchar(local0, " ") + $01) Step $01
                local4 = (New scriptsthread)
                local4\Field1 = piece(local0, local3, " ")
                If (se_isvalidscript(local4\Field1, ".gsc") <> 0) Then
                    local4\Field0 = se_loadscriptexec(local4\Field1)
                    If (local4\Field0 <> Null) Then
                        init_publics_for_script(local4\Field0)
                        skynet_onload()
                    EndIf
                EndIf
            Next
        Case "scripttext"
            se_init()
            For local3 = $01 To (countchar(local0, " ") + $01) Step $01
                local4 = (New scriptsthread)
                local4\Field1 = piece(local0, local3, " ")
                If (se_isvalidscript(local4\Field1, ".gs") <> 0) Then
                    declaredefine("public def", "def")
                    deletefile("SKYNET_TEMP_SCRIPT")
                    se_compilescript(local4\Field1, "SKYNET_TEMP_SCRIPT", "ignoreversion")
                    local4\Field0 = se_loadscriptexec("SKYNET_TEMP_SCRIPT")
                    local4\Field2 = "Compiling"
                    If (local4\Field0 <> Null) Then
                        local4\Field2 = "Successfully compiled"
                        init_publics_for_script(local4\Field0)
                        skynet_onload()
                    ElseIf (((se_error_message = "") And (se_error = $00)) = $00) Then
                        local4\Field2 = ("Error: " + se_error_message)
                    Else
                        local4\Field2 = "Unknown error"
                    EndIf
                    se_clearcompiler()
                    se_error = $00
                    se_error_message = ""
                    Delete Each defines
                    deletefile("SKYNET_TEMP_SCRIPT")
                EndIf
            Next
        Case "custommap"
            server\Field46 = local0
        Case "breachchat"
            local0 = (Str cfg_findbool(local0))
            server\Field47 = (Int local0)
        Case "logsoff"
            local0 = (Str cfg_findbool(local0))
            server\Field50 = (Int local0)
        Case "longculling"
            local0 = (Str cfg_findbool(local0))
            server\Field51 = (Int local0)
    End Select
    Return $00
End Function
