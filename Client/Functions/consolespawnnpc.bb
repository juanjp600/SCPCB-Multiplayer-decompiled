Function consolespawnnpc%(arg0$, arg1$)
    Local local0.npcs
    Local local1$
    Local local2#
    Local local3#
    Local local4#
    Select arg0
        Case "008","008zombie","008-1","infectedhuman","humaninfected","scp008-1","scp-008-1","scp0081","0081","scp-0081","008_1","scp_008_1"
            local0 = createnpc($00, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local0\Field10 = 1.0
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "008"), "%s")
        Case "tentacle","035tentacle","scp035tentacle","scp-035tentacle","scp-035-tentacle","scp035-tentacle"
            local0 = createnpc($01, entityx(me\Field60, $00), (entityy(me\Field60, $00) - 0.12), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "tentacle"), "%s")
        Case "049","scp049","scp-049","plaguedoctor"
            local0 = createnpc($02, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local0\Field10 = 1.0
            n_i\Field6 = local0
            giveachievement("049", $01)
            local1 = format(getlocalstring("console", "spawn"), "SCP-049", "%s")
        Case "049-2","0492","scp-049-2","scp049-2","049zombie","curedhuman","scp0492","scp-0492","049_2","scp_049_2"
            local0 = createnpc($03, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local0\Field10 = 1.0
            local1 = format(getlocalstring("console", "spawn"), "SCP-049-2", "%s")
        Case "066","scp066","scp-066","eric"
            local0 = createnpc($04, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            n_i\Field7 = local0
            local1 = format(getlocalstring("console", "spawn"), "SCP-066", "%s")
        Case "096","scp096","scp-096","shyguy"
            local0 = createnpc($05, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local0\Field10 = 1.0
            n_i\Field4 = local0
            giveachievement("096", $01)
            local1 = format(getlocalstring("console", "spawn"), "SCP-096", "%s")
        Case "106","scp106","scp-106","larry","oldman"
            local2 = entityx(me\Field60, $00)
            local3 = entityy(me\Field60, $00)
            local4 = entityz(me\Field60, $00)
            local0 = createnpc($06, local2, local3, local4)
            local0\Field36 = local2
            local0\Field37 = local3
            local0\Field38 = local4
            local0\Field10 = 2.0
            local1 = format(getlocalstring("console", "spawn"), "SCP-106", "%s")
        Case "173","scp173","scp-173","statue","sculpture"
            local0 = createnpc($07, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            n_i\Field2 = local0
            If (3.0 = n_i\Field2\Field26) Then
                n_i\Field2\Field26 = 0.0
            EndIf
            local1 = format(getlocalstring("console", "spawn"), "SCP-173", "%s")
        Case "372","scp372","scp-372","pj","jumper"
            local0 = createnpc($08, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-372", "%s")
        Case "513-1","5131","scp513-1","scp-513-1","bll","scp-5131","scp5131"
            local0 = createnpc($09, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-513-1", "%s")
        Case "860-2","8602","scp860-2","scp-860-2","forestmonster","scp8602"
            createconsolemsg(format(getlocalstring("console", "spawn.nope"), "SCP-860-2", "%s"), $FF, $00, $00, $00)
        Case "939","scp939","scp-939"
            createconsolemsg(format(getlocalstring("console", "spawn.nope"), getlocalstring("npc", "939"), "%s"), $FF, $00, $00, $00)
        Case "966","scp966","scp-966","sleepkiller"
            local0 = createnpc($0C, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "966"), "%s")
        Case "999","scp999","scp-999","ticklemonster"
            local0 = createnpc($0D, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-999", "%s")
        Case "1048","scp1048","scp-1048","scp-1048","bear","builderbear"
            local0 = createnpc($0E, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-1048", "%s")
        Case "1048a","1048-a","scp1048-a","scp-1048-a","scp1048a","scp-1048a","earbear"
            local0 = createnpc($0F, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-1048-A", "%s")
        Case "1499-1","14991","scp-1499-1","scp1499-1","scp-14991","scp14991"
            local0 = createnpc($10, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), "SCP-1499-1", "%s")
            local0\Field97 = $00
        Case "apache","helicopter"
            local0 = createnpc($11, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "apache"), "%s")
        Case "class-d","classd","d"
            local0 = createnpc($13, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "dclass"), "%s")
        Case "clerk","woman"
            local0 = createnpc($12, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "clerk"), "%s")
        Case "guard"
            local0 = createnpc($14, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "guard"), "%s")
        Case "mtf","ntf"
            local0 = createnpc($15, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00))
            n_i\Field8 = local0
            local1 = format(getlocalstring("console", "spawn"), getlocalstring("npc", "mtf"), "%s")
        Default
            createconsolemsg(getlocalstring("console", "spawn.notfound"), $FF, $00, $00, $00)
            Return $00
    End Select
    If (local0 <> Null) Then
        If (arg1 <> "") Then
            local0\Field10 = (Float arg1)
            local1 = (((local1 + " (State = ") + (Str local0\Field10)) + ")")
        EndIf
    EndIf
    createconsolemsg(local1, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    Return $00
End Function
