Function executeconsolecommand%(arg0$)
    Local local0%
    Local local1.events
    Local local2.events
    Local local3.rooms
    Local local4.items
    Local local5.npcs
    Local local6%
    Local local7.itemtemplates
    Local local8.roomtemplates
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13$
    Local local14$
    Local local15$
    Local local16$
    Local local17$
    Local local22.mp_player
    Local local23%
    Local local24%
    Local local25%
    Local local26#
    Local local37%
    Local local38%
    Local local39%
    Local local40$
    Local local41%
    consoleinput = arg0
    If (instr(consoleinput, " ", $01) <> $00) Then
        local14 = lower(left(consoleinput, (instr(consoleinput, " ", $01) - $01)))
    Else
        local14 = lower(consoleinput)
    EndIf
    Select lower(local14)
        Case "help"
            If (instr(consoleinput, " ", $01) <> $00) Then
                local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Else
                local14 = ""
            EndIf
            consoler = $00
            consoleg = $FF
            consoleb = $FF
            Select local14
                Case "1",""
                    createconsolemsg(getlocalstring("console", "help_1.1"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- roomlist", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- spawnitem [item name / ID]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- spawndrink [drink name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- itemlist", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- ending", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- notarget", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- godmode", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noclipspeed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- infinitestamina", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- noblink", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- money", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- debughud [category]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- codes", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("console", "help_1.2"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("console", "help.command"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "2"
                    createconsolemsg(getlocalstring("console", "help_2.1"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- reset096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- reset372", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- 106retreat", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable066", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable066", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- enable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- doorcontrol", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- unlockcheckpoints", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- unlockexits", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- disablenuke", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- resetfunds", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("console", "help_2.2"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("console", "help.command"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "3"
                    createconsolemsg(getlocalstring("console", "help_3.1"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- camerafog [x]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- spawn [npc type] [state]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- injure [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- infect [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- crystal [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- giveachievement [ID / All]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- wireframe", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- halloween", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- newyear", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- sanic", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("- weed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(getlocalstring("console", "help.command"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "camerafog"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "camerafog", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.camerafog"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "noclip","fly"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "noclip", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.noclip"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "noblink","nb"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "noblink", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.noblink"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "godmode","god"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "god", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.god"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "infinitestamina","is"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "infinitestamina", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.is"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "notarget","nt"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "notarget", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.nt"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "wireframe","wf"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "wireframe", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.wf"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawnitem","si","giveitem"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "spawnitem", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.si"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawncup","givecup","spawndrink","givedrink"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "spawndrink", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.sd"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawn","s"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "spawn", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "reset372"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "reset372", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.r372"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "106retreat"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "106retreat", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.106r"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable106"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable106"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable173"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable173"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable066"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable066"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable096"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable096"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "reset096"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "reset096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.r096"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "doorcontrol"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "doorcontrol", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.dc"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "asd"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "asd", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.asd"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "unlockcheckpoints"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "unlockcheckpoints", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.uc"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable049"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable049"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "disable966"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "disable966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.dis"), "SCP-966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "enable966"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "enable966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(format(getlocalstring("console", "help.SCP.en"), "SCP-966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "revive","undead","resurrect"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "revive", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.revive"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "teleport"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "teleport", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.teleport"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "stopsound","stfu"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "stopsound", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.stfu"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "weed","scp-420-j","420j","scp420-j","scp-420j","420"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "weed", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.weed"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "infect"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "infect", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.infect"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "crystal"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "crystal", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.crystal"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "resetfunds"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "resetfunds", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.rf"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "giveachievement"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "giveachievement", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.ac"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "codes"
                    createconsolemsg(format(getlocalstring("console", "help.title"), "codes", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemultimsg(getlocalstring("console", "help.codes"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Default
                    createconsolemsg(getlocalstring("console", "help.no"), $FF, $96, $00, $00)
            End Select
        Case "ending"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "A"
                    me\Field43 = rand($00, $01)
                Case "B"
                    me\Field43 = rand($02, $03)
                Default
                    me\Field43 = rand($00, $03)
            End Select
            me\Field0 = 1.0
        Case "noclipspeed"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            chs\Field4 = (Float local14)
            createconsolemsg(format(getlocalstring("console", "fly.speed"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "injure"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            me\Field31 = (Float local14)
            createconsolemsg(format(getlocalstring("console", "inj"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "cls","clear"
            clearconsole()
        Case "infect"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            i_008\Field0 = (Float local14)
            createconsolemsg(format(getlocalstring("console", "008"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "crystal"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            i_409\Field0 = (Float local14)
            createconsolemsg(format(getlocalstring("console", "409"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "heal"
            resetnegativestats($00)
            createconsolemsg(getlocalstring("console", "heal"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "teleport","tp"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local11 = $00
            local12 = findroomid(local14)
            For local3 = Each rooms
                If (((local3\Field7\Field6 = local12) Lor ((Str local3\Field7\Field6) = local14)) <> 0) Then
                    local11 = $01
                    If (local3\Field30 <> $00) Then
                        teleportentity(me\Field60, entityx(local3\Field30, $01), (entityy(local3\Field2, $00) + 0.5), entityz(local3\Field30, $01), 0.3, $01, 2.0, $00)
                    Else
                        teleportentity(me\Field60, entityx(local3\Field2, $00), (entityy(local3\Field2, $00) + 0.5), entityz(local3\Field2, $00), 0.3, $00, 2.0, $00)
                    EndIf
                    teleporttoroom(local3)
                    createconsolemsg(format(getlocalstring("console", "tp.success"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Exit
                EndIf
            Next
            If (local11 = $00) Then
                createconsolemsg(getlocalstring("console", "tp.failed"), $FF, $00, $00, $00)
            EndIf
        Case "crps"
            If (mp_ishoster() <> 0) Then
                setplayermodeltexture(ue_players[mp_getmyindex()], $08, $01)
                mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You got new skin (CORPSE). Use this always after death")
            EndIf
        Case "sq"
            If (mp_ishoster() <> 0) Then
                setplayermodel(ue_players[mp_getmyindex()], $03, $00)
                mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You got new skin (SQUID). Use this always after death")
            EndIf
        Case "j12"
            If (mp_ishoster() <> 0) Then
                setplayermodel(ue_players[mp_getmyindex()], $04, $00)
                mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You got new skin (J12). Use this always after death")
            EndIf
        Case "bfall"
            If (mp_ishoster() <> 0) Then
                local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                Select local14
                    Case "on","1","true"
                        ue_players[mp_getmyindex()]\Field4\Field37 = $01
                        mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You set new crouch animation")
                    Case "off","0","false"
                        ue_players[mp_getmyindex()]\Field4\Field37 = $00
                        mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You removed new crouch animation")
                    Default
                        ue_players[mp_getmyindex()]\Field4\Field37 = (ue_players[mp_getmyindex()]\Field4\Field37 = $00)
                        mp_server_sendsinglechatmessage(ue_players[mp_getmyindex()], "You set or removed new crouch animation")
                End Select
            EndIf
        Case "tpp"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local11 = $00
            For local22 = Each mp_player
                If (instr(lower(local22\Field6), local14, $01) <> 0) Then
                    positionentity(me\Field60, local22\Field7, local22\Field8, local22\Field9, $00)
                    resetentity(me\Field60)
                    If (mp_rooms[local22\Field22] <> Null) Then
                        playerroom = mp_rooms[local22\Field22]
                    EndIf
                    local11 = $01
                EndIf
            Next
            If (local11 = $00) Then
                createconsolemsg(getlocalstring("console", "tpp.failed"), $FF, $00, $00, $00)
            EndIf
        Case "roomlist","roomslist","rooms","room list"
            For local8 = Each roomtemplates
                createconsolemsg(((("ID: " + (Str local8\Field6)) + "; Name: ") + local8\Field5), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Next
        Case "spawnitem","si","giveitem","gi"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local11 = $00
            For local7 = Each itemtemplates
                If ((((lower(local7\Field1) = local14) Lor (lower(local7\Field0) = local14)) Lor ((Str local7\Field2) = local14)) <> 0) Then
                    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                        local4 = createitem(local7\Field1, local7\Field2, entityx(me\Field60, $00), entityy(camera, $01), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                        entitytype(local4\Field2, $03, $00)
                    EndIf
                    createconsolemsg(format(getlocalstring("console", "si.success"), local7\Field0, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    local11 = $01
                    Exit
                EndIf
            Next
            If (local11 = $00) Then
                createconsolemsg(getlocalstring("console", "si.failed"), $FF, $00, $00, $00)
            EndIf
        Case "spawncup","givecup","spawndrink","givedrink"
            local14 = upper(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local11 = $00
            If (s2imapcontains(i_294\Field2, local14) <> 0) Then
                local23 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, local14))
                local24 = $00
                local24 = jsongetvalue(local23, "explosion")
                If (jsonisnull(local24) = $00) Then
                    If (jsongetbool(local24) <> 0) Then
                        me\Field58 = 135.0
                        local24 = jsongetvalue(local23, "death_message")
                        If (jsonisnull(local24) = $00) Then
                            msg\Field2 = jsongetstring(local24)
                        EndIf
                    EndIf
                EndIf
                local25 = jsongetarray(jsongetvalue(local23, "color"))
                local26 = jsongetfloat(jsongetvalue(local23, "alpha"))
                local24 = jsongetvalue(local23, "glow")
                If (jsonisnull(local24) = $00) Then
                    If (jsongetbool(local24) <> 0) Then
                        local26 = (- local26)
                    EndIf
                EndIf
                local4 = createitem("Cup", $2B, entityx(me\Field60, $00), entityy(camera, $01), entityz(me\Field60, $00), jsongetint(jsongetarrayvalue(local25, $00)), jsongetint(jsongetarrayvalue(local25, $01)), jsongetint(jsongetarrayvalue(local25, $02)), local26, $00)
                local4\Field1 = local14
                local4\Field0 = format(getlocalstring("items", "cupof"), local14, "%s")
                entitytype(local4\Field2, $03, $00)
                createconsolemsg(format(getlocalstring("console", "si.success"), local4\Field0, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                local11 = $01
            EndIf
            If (local11 = $00) Then
                createconsolemsg(getlocalstring("console", "si.failed"), $FF, $00, $00, $00)
            EndIf
        Case "itemlist","itemslist","items","item list"
            For local7 = Each itemtemplates
                createconsolemsg(format(format(format(getlocalstring("console", "itemlist"), (Str local7\Field2), "{0}"), local7\Field1, "{1}"), local7\Field0, "{2}"), $FF, $96, $00, $00)
            Next
        Case "wireframe","wf"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    wireframestate = $01
                Case "off","0","false"
                    wireframestate = $00
                Default
                    wireframestate = (wireframestate = $00)
            End Select
            If (wireframestate <> 0) Then
                createconsolemsg(getlocalstring("console", "wf.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "wf.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            wireframe(wireframestate)
        Case "reset096","r096"
            If (n_i\Field4 <> Null) Then
                n_i\Field4\Field10 = 0.0
                stopstream_strict(n_i\Field4\Field18)
                n_i\Field4\Field18 = $00
                n_i\Field4\Field21 = $00
                If (n_i\Field4\Field20 <> $00) Then
                    stopstream_strict(n_i\Field4\Field20)
                    n_i\Field4\Field20 = $00
                    n_i\Field4\Field22 = $00
                EndIf
                giveachievement("096", $00)
            EndIf
            createconsolemsg(getlocalstring("console", "r096"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "reset372","r372"
            For local5 = Each npcs
                If (local5\Field4 = $08) Then
                    removenpc(local5)
                    createevent($13, $23, $00, 0.0)
                    Exit
                EndIf
            Next
            createconsolemsg(getlocalstring("console", "r372"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable173","dis173"
            For local5 = Each npcs
                If (local5\Field4 = $07) Then
                    local5\Field26 = 3.0
                    hideentity(local5\Field0)
                    hideentity(local5\Field1)
                    hideentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable173","en173"
            For local5 = Each npcs
                If (local5\Field4 = $07) Then
                    local5\Field26 = 0.0
                    showentity(local5\Field0)
                    showentity(local5\Field1)
                    showentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-173", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable106","dis106"
            For local5 = Each npcs
                If (local5\Field4 = $06) Then
                    local5\Field10 = 0.0
                    local5\Field11 = rnd(22000.0, 27000.0)
                    local5\Field65 = $01
                    hideentity(local5\Field3)
                    hideentity(local5\Field0)
                    hideentity(local5\Field1)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable106","en106"
            For local5 = Each npcs
                If (local5\Field4 = $06) Then
                    local5\Field26 = 0.0
                    local5\Field65 = $00
                    showentity(local5\Field0)
                    showentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-106", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable966","dis966"
            For local5 = Each npcs
                If (local5\Field4 = $0C) Then
                    local5\Field10 = -1.0
                    hideentity(local5\Field3)
                    hideentity(local5\Field0)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable966","en966"
            For local5 = Each npcs
                If (local5\Field4 = $0C) Then
                    local5\Field10 = 0.0
                    showentity(local5\Field3)
                    If (wi\Field5 > $00) Then
                        showentity(local5\Field0)
                    EndIf
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-966", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable049","dis049"
            For local5 = Each npcs
                If (local5\Field4 = $02) Then
                    local5\Field26 = 1.0
                    hideentity(local5\Field0)
                    hideentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable049","en049"
            For local5 = Each npcs
                If (local5\Field4 = $02) Then
                    local5\Field26 = 0.0
                    showentity(local5\Field0)
                    showentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-049", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable066","dis066"
            For local5 = Each npcs
                If (local5\Field4 = $04) Then
                    local5\Field26 = 1.0
                    hideentity(local5\Field0)
                    hideentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable066","en066"
            For local5 = Each npcs
                If (local5\Field4 = $04) Then
                    local5\Field26 = 0.0
                    showentity(local5\Field0)
                    showentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-066", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disable096","dis096"
            For local5 = Each npcs
                If (local5\Field4 = $05) Then
                    local5\Field26 = 1.0
                    hideentity(local5\Field0)
                    hideentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.dis"), "SCP-096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "enable096","en096"
            For local5 = Each npcs
                If (local5\Field4 = $05) Then
                    local5\Field26 = 0.0
                    showentity(local5\Field0)
                    showentity(local5\Field3)
                EndIf
            Next
            createconsolemsg(format(getlocalstring("console", "SCP.en"), "SCP-096", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "106retreat","106r"
            If (1.0 < n_i\Field3\Field10) Then
                n_i\Field3\Field10 = 0.0
                n_i\Field3\Field11 = rnd(22000.0, 27000.0)
                createconsolemsg(getlocalstring("console", "106r"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "106r.failed"), $FF, $96, $00, $00)
            EndIf
        Case "halloween"
            n_i\Field10 = (n_i\Field10 = $00)
            If (n_i\Field10 <> 0) Then
                n_i\Field11 = $00
                n_i\Field12 = $00
                local9 = loadtexture_strict("GFX\NPCs\scp_173_H.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local9, $00, $00)
                entitytexture(n_i\Field2\Field1, local9, $00, $00)
                deletesingletextureentryfromcache(local9, $00)
                local9 = $00
                createconsolemsg(getlocalstring("console", "halloween.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                local10 = loadtexture_strict("GFX\NPCs\scp_173.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local10, $00, $00)
                entitytexture(n_i\Field2\Field1, local10, $00, $00)
                deletesingletextureentryfromcache(local10, $00)
                local10 = $00
                createconsolemsg(getlocalstring("console", "halloween.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "newyear"
            n_i\Field11 = (n_i\Field11 = $00)
            If (n_i\Field11 <> 0) Then
                n_i\Field10 = $00
                n_i\Field12 = $00
                local9 = loadtexture_strict("GFX\NPCs\scp_173_NY.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local9, $00, $00)
                entitytexture(n_i\Field2\Field1, local9, $00, $00)
                deletesingletextureentryfromcache(local9, $00)
                local9 = $00
                createconsolemsg(getlocalstring("console", "newyear.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                local10 = loadtexture_strict("GFX\NPCs\scp_173.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local10, $00, $00)
                entitytexture(n_i\Field2\Field1, local10, $00, $00)
                deletesingletextureentryfromcache(local10, $00)
                local10 = $00
                createconsolemsg(getlocalstring("console", "newyear.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "joke"
            n_i\Field12 = (n_i\Field12 = $00)
            If (n_i\Field12 <> 0) Then
                n_i\Field10 = $00
                n_i\Field11 = $00
                local9 = loadtexture_strict("GFX\NPCs\scp_173_J.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local9, $00, $00)
                entitytexture(n_i\Field2\Field1, local9, $00, $00)
                deletesingletextureentryfromcache(local9, $00)
                local9 = $00
                createconsolemsg(getlocalstring("console", "aprilfools.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                local10 = loadtexture_strict("GFX\NPCs\scp_173.png", $01, $00, $01)
                entitytexture(n_i\Field2\Field0, local10, $00, $00)
                entitytexture(n_i\Field2\Field1, local10, $00, $00)
                deletesingletextureentryfromcache(local10, $00)
                local10 = $00
                createconsolemsg(getlocalstring("console", "aprilfools.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "sanic"
            chs\Field6 = (chs\Field6 = $00)
            If (chs\Field6 <> 0) Then
                createconsolemsg(getlocalstring("console", "sanic.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "sanic.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "scp-420-j","420","weed","scp420-j","scp-420j","420j"
            For local12 = $01 To $14 Step $01
                If (rand($02, $01) = $01) Then
                    local14 = "Some SCP-420-J"
                    local11 = $10
                Else
                    local14 = "Joint"
                    local11 = $12
                EndIf
                local4 = createitem(local14, local11, ((cos((18.0 * (Float local12))) * rnd(0.3, 0.5)) + entityx(me\Field60, $01)), entityy(camera, $01), ((sin((18.0 * (Float local12))) * rnd(0.3, 0.5)) + entityz(me\Field60, $01)), $00, $00, $00, 1.0, $00)
                entitytype(local4\Field2, $03, $00)
            Next
            playsound_strict(loadtempsound("SFX\Music\Using420J.ogg"), $00, $01)
            mp_synchronize3dsound(Null, "SFX\Music\Using420J.ogg", me\Field60, 20.0, 1.0)
        Case "godmode","god"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    chs\Field0 = $01
                Case "off","0","false"
                    chs\Field0 = $00
                Default
                    chs\Field0 = (chs\Field0 = $00)
            End Select
            If (chs\Field0 <> 0) Then
                createconsolemsg(getlocalstring("console", "god.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "god.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "revive","undead","resurrect"
            If (mp_getsocket() <> $00) Then
                mp_respawnplayer(ue_players[mp_getmyindex()])
            EndIf
            resetnegativestats($01)
            If (t\Field3[$0A] <> $00) Then
                freeentity(t\Field3[$0A])
                t\Field3[$0A] = $00
            EndIf
            me\Field9 = $01
        Case "noclip","fly"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    chs\Field3 = $01
                    me\Field9 = $01
                Case "off","0","false"
                    chs\Field3 = $00
                    rotateentity(me\Field60, 0.0, entityyaw(me\Field60, $00), 0.0, $00)
                Default
                    chs\Field3 = (chs\Field3 = $00)
                    If (chs\Field3 = $00) Then
                        rotateentity(me\Field60, 0.0, entityyaw(me\Field60, $00), 0.0, $00)
                    Else
                        me\Field9 = $01
                    EndIf
            End Select
            If (chs\Field3 <> 0) Then
                createconsolemsg(getlocalstring("console", "fly.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "fly.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            me\Field36 = 0.0
        Case "noblink","nb"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    chs\Field1 = $01
                Case "off","0","false"
                    chs\Field1 = $00
                Default
                    chs\Field1 = (chs\Field1 = $00)
            End Select
            If (chs\Field1 <> 0) Then
                createconsolemsg(getlocalstring("console", "nb.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "nb.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "debughud","dbh"
            If (instr(consoleinput, " ", $01) <> $00) Then
                local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Else
                local14 = ""
            EndIf
            Select local14
                Case "game","1"
                    chs\Field8 = $01
                Case "player","me","2"
                    chs\Field8 = $02
                Case "scps","scp","3"
                    chs\Field8 = $03
                Case "mp","multiplayer","4"
                    chs\Field8 = $04
                Case "off","false","0"
                    chs\Field8 = $00
                Default
                    createconsolemsg(getlocalstring("console", "debug.cate"), $FF, $96, $00, $00)
            End Select
        Case "stopsound","stfu"
            killsounds($01)
            For local1 = Each events
                If (local1\Field0 = $03) Then
                    For local12 = $00 To $02 Step $01
                        removenpc(local1\Field1\Field15[local12])
                        If (local12 < $02) Then
                            If (local1\Field1\Field11[local12] <> $00) Then
                                translateentity(local1\Field1\Field11[local12], 0.0, -1000.0, 0.0, $01)
                            EndIf
                        EndIf
                    Next
                    If (1.0 = n_i\Field2\Field26) Then
                        n_i\Field2\Field26 = 0.0
                    EndIf
                    positionentity(n_i\Field2\Field3, 0.0, 0.0, 0.0, $00)
                    resetentity(n_i\Field2\Field3)
                    positionentity(local1\Field1\Field11[$02], entityx(local1\Field1\Field11[$02], $01), (local1\Field1\Field4 + 1.5), entityz(local1\Field1\Field11[$02], $01), $01)
                    rotateentity(local1\Field1\Field11[$02], entitypitch(local1\Field1\Field11[$02], $01), entityyaw(local1\Field1\Field11[$02], $01), entityroll(local1\Field1\Field11[$02], $01), $01)
                    removeevent(local1)
                    Exit
                EndIf
            Next
            createconsolemsg(getlocalstring("console", "stfu"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "camerafog","cf"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            If (opt\Field54 = $01) Then
                fog\Field0 = (Float local14)
            Else
                fog\Field0 = clamp((Float local14), 6.0, 50.0)
            EndIf
            createconsolemsg(format(getlocalstring("console", "fog"), (Str fog\Field0), "{0}"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "spawn","s"
            local13 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local14 = piece(local13, $01, " ")
            local15 = piece(local13, $02, " ")
            If (local14 <> local15) Then
                consolespawnnpc(local14, local15)
            Else
                consolespawnnpc(local14, "")
            EndIf
        Case "infinitestamina","infstam","is"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    chs\Field5 = $01
                Case "off","0","false"
                    chs\Field5 = $00
                Default
                    chs\Field5 = (chs\Field5 = $00)
            End Select
            If (chs\Field5 <> 0) Then
                createconsolemsg(getlocalstring("console", "is.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "is.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "money","rich"
            For local12 = $01 To $14 Step $01
                If (rand($02, $01) = $01) Then
                    local14 = "Quarter"
                    local11 = $6A
                Else
                    local14 = "Coin"
                    local11 = $6B
                EndIf
                local4 = createitem(local14, local11, ((cos((18.0 * (Float local12))) * rnd(0.3, 0.5)) + entityx(me\Field60, $01)), entityy(camera, $01), ((sin((18.0 * (Float local12))) * rnd(0.3, 0.5)) + entityz(me\Field60, $01)), $00, $00, $00, 1.0, $00)
                entitytype(local4\Field2, $03, $00)
            Next
        Case "doorcontrol"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    remotedooron = $01
                Case "off","0","false"
                    remotedooron = $00
                Default
                    remotedooron = (remotedooron = $00)
            End Select
            If (remotedooron <> 0) Then
                createconsolemsg(getlocalstring("console", "door.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "door.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            For local2 = Each events
                If (local2\Field0 = $3A) Then
                    updatelever(local2\Field1\Field13[$02]\Field0, $00, $50, -80.0)
                    rotateentity(local2\Field1\Field13[$02]\Field0, ((-160.0 * (Float remotedooron)) + 80.0), entityyaw(local2\Field1\Field13[$02]\Field0, $00), 0.0, $00)
                    Exit
                EndIf
            Next
        Case "unlockcheckpoints"
            For local2 = Each events
                If (local2\Field0 = $0C) Then
                    local2\Field4 = 0.0
                    updatelever(local2\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    rotateentity(local2\Field1\Field13[$00]\Field0, 80.0, entityyaw(local2\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                ElseIf (local2\Field0 = $23) Then
                    local2\Field2 = 2.0
                    updatelever(local2\Field1\Field11[$01], $00, $50, -80.0)
                    rotateentity(local2\Field1\Field11[$01], 0.0, entityyaw(local2\Field1\Field11[$01], $00), 0.0, $00)
                    If (local2\Field1\Field17[$00] <> Null) Then
                        freeemitter(local2\Field1\Field17[$00], $00)
                    EndIf
                EndIf
            Next
            createconsolemsg(getlocalstring("console", "uc"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "disablenuke"
            For local1 = Each events
                If (local1\Field0 = $1F) Then
                    local1\Field2 = 0.0
                    updatelever(local1\Field1\Field13[$00]\Field0, $00, $50, -80.0)
                    updatelever(local1\Field1\Field13[$01]\Field0, $00, $50, -80.0)
                    rotateentity(local1\Field1\Field13[$00]\Field0, 80.0, entityyaw(local1\Field1\Field13[$00]\Field0, $00), 0.0, $00)
                    rotateentity(local1\Field1\Field13[$01]\Field0, 80.0, entityyaw(local1\Field1\Field13[$01]\Field0, $00), 0.0, $00)
                    Exit
                EndIf
            Next
        Case "unlockexits"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "a"
                    For local1 = Each events
                        If (local1\Field0 = $2D) Then
                            local1\Field4 = 1.0
                            local1\Field1\Field14[$01]\Field6 = $01
                            Exit
                        EndIf
                    Next
                    createconsolemsg(getlocalstring("console", "ue.a"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "b"
                    For local1 = Each events
                        If (local1\Field0 = $2B) Then
                            local1\Field4 = 1.0
                            local1\Field1\Field14[$01]\Field6 = $01
                            Exit
                        EndIf
                    Next
                    createconsolemsg(getlocalstring("console", "ue.b"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Default
                    For local1 = Each events
                        If (((local1\Field0 = $2B) Lor (local1\Field0 = $2D)) <> 0) Then
                            local1\Field4 = 1.0
                            local1\Field1\Field14[$01]\Field6 = $01
                        EndIf
                    Next
                    createconsolemsg(getlocalstring("console", "ue"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            End Select
            remotedooron = $01
        Case "kill","suicide"
            chs\Field0 = $00
            kill($00, $01, $00, $01)
            Select rand($04, $01)
                Case $01
                    msg\Field2 = getlocalstring("death", "kill_1")
                Case $02
                    msg\Field2 = format(getlocalstring("death", "kill_2"), subjectname, "%s")
                Case $03
                    msg\Field2 = getlocalstring("death", "kill_3")
                Case $04
                    msg\Field2 = format(getlocalstring("death", "kill_4"), subjectname, "%s")
            End Select
        Case "tele"
            local13 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local14 = piece(local13, $01, " ")
            local15 = piece(local13, $02, " ")
            local16 = piece(local13, $03, " ")
            positionentity(me\Field60, (Float local14), (Float local15), (Float local16), $00)
            positionentity(camera, (Float local14), (Float local15), (Float local16), $00)
            resetentity(me\Field60)
            resetentity(camera)
            createconsolemsg(format(format(format(getlocalstring("console", "tele"), (Str entityx(me\Field60, $00)), "{0}"), (Str entityy(me\Field60, $00)), "{1}"), (Str entityz(me\Field60, $00)), "{2}"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "asd"
            chs\Field1 = $01
            chs\Field2 = $01
            chs\Field3 = $01
            chs\Field0 = $01
            chs\Field5 = $01
            fog\Field0 = 17.0
            killsounds($01)
            For local1 = Each events
                If (local1\Field0 = $03) Then
                    For local12 = $00 To $02 Step $01
                        removenpc(local1\Field1\Field15[local12])
                        If (local12 < $02) Then
                            freeentity(local1\Field1\Field11[local12])
                            local1\Field1\Field11[local12] = $00
                        EndIf
                    Next
                    If (1.0 = n_i\Field2\Field26) Then
                        n_i\Field2\Field26 = 0.0
                    EndIf
                    positionentity(n_i\Field2\Field3, 0.0, 0.0, 0.0, $00)
                    resetentity(n_i\Field2\Field3)
                    positionentity(local1\Field1\Field11[$02], entityx(local1\Field1\Field11[$02], $01), (local1\Field1\Field4 + 1.5), entityz(local1\Field1\Field11[$02], $01), $01)
                    rotateentity(local1\Field1\Field11[$02], entitypitch(local1\Field1\Field11[$02], $01), entityyaw(local1\Field1\Field11[$02], $01), entityroll(local1\Field1\Field11[$02], $01), $01)
                    removeevent(local1)
                    Exit
                EndIf
            Next
            createconsolemsg(getlocalstring("console", "stfu"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "notarget","nt"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Select local14
                Case "on","1","true"
                    chs\Field2 = $01
                Case "off","0","false"
                    chs\Field2 = $00
                Default
                    chs\Field2 = (chs\Field2 = $00)
            End Select
            If (chs\Field2 <> 0) Then
                createconsolemsg(getlocalstring("console", "nt.on"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            Else
                createconsolemsg(getlocalstring("console", "nt.off"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
        Case "spawnpumpkin","pumpkin"
            createconsolemsg(getlocalstring("console", "pumpkin"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "teleport173"
            positionentity(n_i\Field2\Field3, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.2), entityz(me\Field60, $00), $00)
            resetentity(n_i\Field2\Field3)
        Case "seteventstate"
            local13 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            local14 = piece(local13, $01, " ")
            local15 = piece(local13, $02, " ")
            local16 = piece(local13, $03, " ")
            local17 = piece(local13, $04, " ")
            local37 = $00
            If (((((local14 = "") Lor (local15 = "")) Lor (local16 = "")) Lor (local17 = "")) <> 0) Then
                createconsolemsg(getlocalstring("console", "ses.failed"), $FF, $96, $00, $00)
            Else
                For local1 = Each events
                    If (playerroom = local1\Field1) Then
                        If (lower(local14) <> "keep") Then
                            local1\Field2 = (Float local14)
                        EndIf
                        If (lower(local15) <> "keep") Then
                            local1\Field3 = (Float local15)
                        EndIf
                        If (lower(local16) <> "keep") Then
                            local1\Field4 = (Float local16)
                        EndIf
                        If (lower(local17) <> "keep") Then
                            local1\Field5 = (Float local17)
                        EndIf
                        createconsolemsg(format(format(format(format(getlocalstring("console", "ses.success"), (Str local1\Field2), "{0}"), (Str local1\Field3), "{1}"), (Str local1\Field4), "{2}"), (Str local1\Field5), "{3}"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local37 = $01
                        Exit
                    EndIf
                Next
                If (local37 = $00) Then
                    createconsolemsg(getlocalstring("console", "ses.failed.apply"), $FF, $96, $00, $00)
                EndIf
            EndIf
        Case "giveachievement"
            If (instr(consoleinput, " ", $01) <> $00) Then
                local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            Else
                local14 = ""
            EndIf
            If (local14 = "all") Then
                local38 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
                local39 = jsongetarraysize(local38)
                For local12 = $00 To (local39 - $01) Step $01
                    local40 = jsongetstring(jsongetvalue(jsongetarrayvalue(local38, local12), "id"))
                    If (opt\Field54 <> 0) Then
                        giveachievement(local40, $01)
                    ElseIf ((((local40 <> "console") And (local40 <> "keter")) And (local40 <> "apollyon")) <> 0) Then
                        giveachievement(local40, $01)
                    EndIf
                Next
                saveachievementsfile()
                createconsolemsg(getlocalstring("console", "ga.all"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            EndIf
            If (s2imapcontains(achievementsindex, local14) <> 0) Then
                giveachievement(local14, $01)
                local41 = jsongetvalue(jsongetvalue(jsongetvalue(localachievementsarray, "translations"), local14), "name")
                If (jsonisnull(local41) <> 0) Then
                    local41 = jsongetvalue(jsongetvalue(jsongetvalue(achievementsarray, "translations"), local14), "name")
                EndIf
                createconsolemsg(format(getlocalstring("console", "ga.success"), jsongetstring(local41), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            ElseIf (local14 <> "all") Then
                createconsolemsg(format(getlocalstring("console", "ga.failed"), local14, "%s"), $FF, $00, $00, $00)
            EndIf
        Case "427state"
            local14 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
            i_427\Field1 = (70.0 * (Float local14))
            createconsolemsg(format(getlocalstring("console", "427"), local14, "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "teleport106"
            If (n_i\Field3\Field65 = $00) Then
                n_i\Field3\Field10 = 2.0
                n_i\Field3\Field26 = 0.0
                n_i\Field3\Field36 = entityx(me\Field60, $00)
                n_i\Field3\Field37 = entityy(me\Field60, $00)
                n_i\Field3\Field38 = entityz(me\Field60, $00)
            EndIf
        Case "jorge"
            createconsolemsg(getlocalstring("console", "jorge"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "resetfunds"
            For local4 = Each items
                Select local4\Field4\Field2
                    Case $61
                        local4\Field12 = 10.0
                    Case $62
                        local4\Field12 = 1000.0
                End Select
            Next
            createconsolemsg(getlocalstring("console", "funds"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Case "codes"
            createconsolemsg(getlocalstring("console", "codes_1"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_2"), (Str code_dr_maynard), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_3"), "7816", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_4"), "2411", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_5"), (Str code_o5_council), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_6"), (Str code_maintenance_tunnels), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_7"), "5731", "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(format(getlocalstring("console", "codes_9"), (Str code_dr_gears), "%s"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
            createconsolemsg(getlocalstring("console", "codes_8"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Default
            createconsolemsg(getlocalstring("console", "notfound"), $FF, $00, $00, $00)
    End Select
    consoleinput = ""
    Return $00
End Function
