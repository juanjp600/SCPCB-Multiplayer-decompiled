Function updatelanguageselector%()
    Local local0$
    Local local1$
    Local local2.listlanguage
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13.listlanguage
    Local local14.listlanguage
    Local local15%
    Local local16.listlanguage
    Local local17%
    Local local19#
    Local local20#
    Local local21%
    Local local22$
    Local local23%
    Local local24$
    Local local25$
    Local local26$
    Local local27$
    Local local28$
    Local local29$
    Local local30$
    Local local31$
    Local local32%
    Local local33%
    Local local34%
    Local local35%
    countryflags = creates2imap()
    If (getuserlanguage() = "zh-CN") Then
        local0 = "https://???????/cbue/"
    Else
        local0 = "https://???????/cbue/"
    EndIf
    local1 = (getenv("AppData") + "\scpcb-mr\temp\")
    deletefolder(local1)
    createdir(local1)
    If (filetype("Localization\") <> $02) Then
        createdir("Localization\")
    EndIf
    createdir((local1 + "/flags/"))
    downloadfile((local0 + "languages.json"), (local1 + "languages.json"))
    local3 = jsonparsefromfile((local1 + "languages.json"))
    If (jsonhasparseerror(local3) = $00) Then
        local5 = jsongetarray(local3)
        local6 = jsongetarraysize(local5)
        For local7 = $00 To (local6 - $01) Step $01
            local8 = jsongetarrayvalue(local5, local7)
            local2 = (New listlanguage)
            local2\Field0 = jsongetstring(jsongetvalue(local8, "name"))
            local2\Field1 = jsongetstring(jsongetvalue(local8, "id"))
            local2\Field2 = jsongetstring(jsongetvalue(local8, "author"))
            local2\Field3 = jsongetstring(jsongetvalue(local8, "update"))
            local2\Field5 = jsonisnull(jsongetvalue(local8, "size"))
            local2\Field6 = jsongetbool(jsongetvalue(local8, "perfect"))
            local2\Field4 = jsongetstring(jsongetvalue(local8, "flag"))
            local2\Field7 = jsongetint(jsongetvalue(local8, "size"))
            local2\Field8 = jsongetstring(jsongetvalue(local8, "compatible"))
            If (filetype(((local1 + "flags/") + local2\Field4)) <> $01) Then
                downloadfile(((local0 + "flags/") + local2\Field4), ((local1 + "flags/") + local2\Field4))
            EndIf
            If (s2imapcontains(countryflags, local2\Field4) = $00) Then
                s2imapset(countryflags, local2\Field4, loadimage(((local1 + "flags\") + local2\Field4)))
            EndIf
            If (s2imapcontains(countryflags, local2\Field4) = $00) Then
                Return $01
            EndIf
        Next
    Else
        Return $01
    EndIf
    setbuffer(backbuffer())
    cls()
    flip($01)
    local10 = createimage($1C4, $FE, $01)
    local11 = loadanimimage_strict("GFX\Menu\buttons.png", $15, $15, $00, $07)
    local12 = (fontheight() Sar $01)
    local13 = Null
    local14 = Null
    local15 = $00
    local16 = Null
    local17 = $00
    apptitle(getlocalstring("language", "title"), "")
    Repeat
        mouseposx = (Float mousex())
        mouseposy = (Float mousey())
        mo\Field0 = mousehit($01)
        mo\Field2 = mousedown($01)
        Select local15
            Case $02
                If (local16\Field5 = $00) Then
                    If (opt\Field59 <> 0) Then
                        downloadfile(((local0 + local16\Field1) + ".zip"), (local1 + "/local.zip"))
                    Else
                        downloadfilethread(((local0 + local16\Field1) + ".zip"), (local1 + "/local.zip"))
                    EndIf
                EndIf
                downloadfile((("https://????????/translations/scpcb-ue/local-ini/" + local16\Field1) + "/file/"), (local1 + "/local.ini"))
                downloadfile((("https://????????/translations/scpcb-ue/achievements-jsonc/" + local16\Field1) + "/file/"), (local1 + "/achievements.jsonc"))
                local15 = $03
            Case $05
                createdir(("Localization\" + local16\Field1))
                If (local16\Field5 = $00) Then
                    unzip((local1 + "/local.zip"), ("Localization\" + local16\Field1), "")
                EndIf
                createdir((("Localization\" + local16\Field1) + "/Data"))
                copyfile((local1 + "/local.ini"), (("Localization\" + local16\Field1) + "/Data/local.ini"))
                copyfile((local1 + "/achievements.jsonc"), (("Localization\" + local16\Field1) + "/Data/achievements.jsonc"))
                local17 = millisecs()
                local15 = $08
            Case $07
                deletefolder(("Localization\" + local13\Field1))
                local17 = millisecs()
                local15 = $08
        End Select
        If (local15 = $08) Then
            If ((millisecs() - local17) > $5DC) Then
                local15 = $00
            EndIf
        EndIf
        setbuffer(backbuffer())
        cls()
        color($FF, $FF, $FF)
        If (local9 = $00) Then
            local9 = loadimage_strict("GFX\Menu\Language.png")
        EndIf
        drawblock(local9, $00, $00, $00)
        rect($1DF, $C3, $9B, $6E, $01)
        If (local21 > $0D) Then
            local20 = (200.0 - ((20.0 * scrollmenuheight) * scrollbary))
            setbuffer(imagebuffer(local10, $00))
            drawimage(local9, $FFFFFFEC, $FFFFFF3D, $00)
            local21 = $00
            For local2 = Each listlanguage
                color($00, $00, $01)
                limittextwithimage((((local2\Field0 + "(") + local2\Field1) + ")"), $02, (Int (local20 - 195.0)), $1B0, s2imapget(countryflags, local2\Field4), $00)
                If (mouseon($14, (Int (local20 - (Float local12))), $1B0, $14) <> 0) Then
                    drawimage(local11, $19A, (Int ((local20 - 195.0) - (Float local12))), $05)
                    If (mouseon($1AE, (Int (local20 - (Float local12))), $15, $15) <> 0) Then
                        color($96, $96, $96)
                        rect($19A, (Int ((local20 - 195.0) - (Float local12))), $14, $14, $00)
                        local14 = local2
                    EndIf
                EndIf
                If (local2\Field1 = opt\Field55) Then
                    color($C8, $00, $00)
                    rect($00, (Int ((local20 - 195.0) - (Float local12))), $1AE, $14, $00)
                EndIf
                If (((local13 <> Null) And (local2 = local13)) <> 0) Then
                    color($00, $00, $01)
                    rect($00, (Int ((local20 - 195.0) - (Float local12))), $1AE, $14, $00)
                EndIf
                If (mouseon($14, (Int (local20 - (Float local12))), $1B0, $14) <> 0) Then
                    color($96, $96, $96)
                    rect($00, (Int ((local20 - 195.0) - (Float local12))), $1AE, $14, $00)
                    If (mo\Field0 <> 0) Then
                        local13 = local2
                    EndIf
                EndIf
                local20 = (local20 + 20.0)
                local21 = (local21 + $01)
            Next
            setbuffer(backbuffer())
            drawblock(local10, $14, $C3, $00)
            color($0A, $0A, $0A)
            rect($1C4, $C3, $14, $FE, $01)
            scrollmenuheight = (Float (local21 - $0C))
            scrollbary = updatelauncherscrollbar($14, $FE, $1C4, (Int (((254.0 - (254.0 - (4.0 * scrollmenuheight))) * scrollbary) + 195.0)), $14, (Int (254.0 - (4.0 * scrollmenuheight))), scrollbary, $01)
        Else
            local20 = 200.0
            local21 = $00
            For local2 = Each listlanguage
                color($00, $00, $01)
                limittextwithimage((((local2\Field0 + "(") + local2\Field1) + ")"), $15, (Int local20), $1B0, s2imapget(countryflags, local2\Field4), $00)
                If (mouseon($14, (Int (local20 - (Float local12))), $1AE, $14) <> 0) Then
                    drawimage(local11, $1AE, (Int (local20 - 4.0)), $05)
                    If (mouseon($1AE, (Int (local20 - 4.0)), $15, $15) <> 0) Then
                        color($96, $96, $96)
                        rect($1AE, (Int (local20 - 4.0)), $14, $14, $00)
                        local14 = local2
                    EndIf
                EndIf
                If (local2\Field1 = opt\Field55) Then
                    color($C8, $00, $00)
                    rect($14, (Int (local20 - (Float local12))), $1AE, $14, $00)
                EndIf
                If (((local13 <> Null) And (local2 = local13)) <> 0) Then
                    color($00, $00, $01)
                    rect($14, (Int (local20 - (Float local12))), $1AE, $14, $00)
                EndIf
                If (mouseon($14, (Int (local20 - (Float local12))), $1B0, $14) <> 0) Then
                    color($96, $96, $96)
                    rect($14, (Int (local20 - (Float local12))), $1AE, $14, $00)
                    If (mo\Field0 <> 0) Then
                        local13 = local2
                    EndIf
                EndIf
                local20 = (local20 + 20.0)
                local21 = (local21 + $01)
            Next
            scrollmenuheight = (Float local21)
        EndIf
        local22 = getlocalstring("language", "more")
        color($64, $64, $64)
        If (local15 = $01) Then
            local22 = getlocalstring("language", "downloading")
            If (opt\Field59 = $00) Then
                updatelauncherbutton($1DF, $13B, $9B, $1E, "0%", $00, $00, $01, $FF, $FF, $FF)
            EndIf
            local15 = $02
        ElseIf (local15 = $02) Then
            If (local16\Field5 <> 0) Then
                local15 = $04
            Else
                local15 = $03
            EndIf
        ElseIf (local15 = $03) Then
            If (opt\Field59 = $00) Then
                local22 = format(format(getlocalstring("language", "downloading.filesize"), simplefilesize(getdownloadfilethreadsize()), "{0}"), simplefilesize(local16\Field7), "{1}")
                updatelauncherbutton($1DF, $13B, $9B, $1E, ((Str (Int ceil((((Float getdownloadfilethreadsize()) / (Float local16\Field7)) * 100.0)))) + "%"), $00, $00, $01, $FF, $FF, $FF)
                If (getdownloadfilethreadsize() >= local16\Field7) Then
                    local15 = $04
                EndIf
            Else
                local15 = $04
            EndIf
        ElseIf (local15 = $04) Then
            local22 = getlocalstring("language", "unpacking")
            updatelauncherbutton($1DF, $13B, $9B, $1E, "100%", $00, $00, $01, $FF, $FF, $FF)
            local15 = $05
        ElseIf (local15 = $06) Then
            local22 = getlocalstring("language", "uninstalling")
            local15 = $07
        ElseIf (local15 = $08) Then
            local22 = getlocalstring("language", "done")
        EndIf
        color($00, $00, $01)
        rowtext(local22, $1E1, $C7, $97, $66, $00, 1.0)
        If (local13 <> Null) Then
            If (local13\Field1 = opt\Field55) Then
                If (updatelauncherbuttonwithimage($1DF, $16D, $9B, $1E, getlocalstring("language", "contribute"), $00, local11, $04, (Int isdownloadinglanguage(local15))) <> 0) Then
                    execfile_strict("https://github.ziyuesinicization.site/Jabka666/scpcb-ue-my/wiki/How-to-contribute-a-language")
                EndIf
            ElseIf (local13\Field0 = "English") Then
                If (updatelauncherbuttonwithimage($1DF, $16D, $9B, $1E, getlocalstring("language", "set"), $00, local11, $02, (Int isdownloadinglanguage(local15))) <> 0) Then
                    setlanguage(local13\Field1, $01)
                    freeimage(local9)
                    local9 = $00
                    iniwritestring(optionfile, "Global", "Language", opt\Field55, $01)
                EndIf
            ElseIf (filetype(("Localization\" + local13\Field1)) = $02) Then
                If (local13\Field1 <> opt\Field55) Then
                    If (updatelauncherbuttonwithimage($1DF, $13B, $9B, $1E, getlocalstring("language", "uninstall"), $00, local11, $03, (Int isdownloadinglanguage(local15))) <> 0) Then
                        local15 = $06
                        local16 = local13
                    EndIf
                    If (updatelauncherbuttonwithimage($1DF, $16D, $9B, $1E, getlocalstring("language", "set"), $00, local11, $02, (Int isdownloadinglanguage(local15))) <> 0) Then
                        setlanguage(local13\Field1, $01)
                        freeimage(local9)
                        local9 = $00
                        iniwritestring(optionfile, "Global", "Language", opt\Field55, $01)
                    EndIf
                EndIf
            Else
                If (((local15 = $00) Lor (local15 = $08)) <> 0) Then
                    color($FF, $FF, $FF)
                    text($1FD, $14C, getlocalstring("language", "speedup"), $00, $01)
                    local23 = updatelaunchertick($1DF, $143, opt\Field59, $00)
                    If (local23 <> opt\Field59) Then
                        If (local23 <> 0) Then
                            color($FF, $FF, $FF)
                            Repeat
                                mouseposx = (Float mousex())
                                mouseposy = (Float mousey())
                                mo\Field0 = mousehit($01)
                                text($140, $B4, getlocalstring("language", "speedup.notice_1"), $01, $00)
                                text($140, $C8, getlocalstring("language", "speedup.notice_2"), $01, $00)
                                text($140, $DC, getlocalstring("language", "speedup.notice_3"), $01, $00)
                                text($140, $104, getlocalstring("language", "speedup.notice_4"), $01, $00)
                                If (updatelauncherbutton($C8, $12C, $64, $1E, getlocalstring("language", "yes"), $00, $00, $00, $FF, $FF, $FF) <> 0) Then
                                    delay($64)
                                    opt\Field59 = $01
                                    Exit
                                EndIf
                                If (updatelauncherbutton($154, $12C, $64, $1E, getlocalstring("language", "no"), $00, $00, $00, $FF, $FF, $FF) <> 0) Then
                                    delay($64)
                                    Exit
                                EndIf
                                delay($0A)
                                flip($01)
                                cls()
                            Forever
                        Else
                            opt\Field59 = $00
                        EndIf
                    EndIf
                EndIf
                If (updatelauncherbuttonwithimage($1DF, $16D, $9B, $1E, getlocalstring("language", "download"), $00, local11, $01, (Int isdownloadinglanguage(local15))) <> 0) Then
                    local15 = $01
                    local16 = local13
                EndIf
            EndIf
        EndIf
        If (updatelauncherbuttonwithimage($1DF, $19F, $9B, $1E, getlocalstring("menu", "back"), $00, local11, $00, (Int isdownloadinglanguage(local15))) <> 0) Then
            Exit
        EndIf
        If (local14 <> Null) Then
            local24 = format(getlocalstring("language", "name"), local14\Field0, "%s")
            local25 = format(getlocalstring("language", "id"), local14\Field1, "%s")
            local26 = ""
            local27 = ""
            local28 = ""
            local29 = ""
            local30 = ""
            local31 = ""
            local32 = fontwidth()
            local33 = fontheight()
            local34 = (Int ((Float local33) * 4.5))
            color($FF, $FF, $FF)
            If (local14\Field1 <> "en") Then
                local28 = format(getlocalstring("language", "author"), local14\Field2, "%s")
                local29 = format(getlocalstring("language", "full"), getlocalstring("language", "yes"), "%s")
                local30 = format(getlocalstring("language", "full"), getlocalstring("language", "no"), "%s")
                local31 = format(getlocalstring("language", "compatible"), ("v" + local14\Field8), "%s")
                If (local14\Field5 <> 0) Then
                    local34 = (local33 Shl $03)
                Else
                    local26 = format(getlocalstring("language", "size"), simplefilesize(local14\Field7), "%s")
                    local27 = format(getlocalstring("language", "lastmod"), local14\Field3, "%s")
                    local34 = (local33 * $0D)
                EndIf
            EndIf
            local35 = (Int max(max(max(max(max(max(max((Float stringwidth(local24)), (Float stringwidth(local25))), (Float stringwidth(local28))), (Float stringwidth(local29))), (Float stringwidth(local26))), (Float stringwidth(local31))), (Float stringwidth(local30))), (Float stringwidth(local27))))
            local19 = (mouseposx + 10.0)
            local20 = (mouseposy + 10.0)
            If (640.0 < ((local19 + (Float local35)) + (Float local32))) Then
                local19 = ((local19 - (Float local35)) - 10.0)
            EndIf
            If (480.0 < ((local20 + (Float local34)) + (Float local33))) Then
                local20 = ((local20 - (Float local34)) - 15.0)
            EndIf
            renderframe((Int local19), (Int local20), (local35 + local32), local34, $00, $00, $00)
            local19 = (local19 + 5.0)
            textex((Int local19), (Int (local20 + 8.0)), local24, $00, $00)
            textex((Int local19), (Int (local20 + 23.0)), local25, $00, $00)
            If (local14\Field1 <> "en") Then
                textex((Int local19), (Int (local20 + 38.0)), local28, $00, $00)
                If (local14\Field6 <> 0) Then
                    dualcolortext((Int local19), (Int (local20 + 53.0)), format(getlocalstring("language", "full"), "", "%s"), getlocalstring("language", "yes"), $FF, $FF, $FF, $00, $C8, $00)
                Else
                    dualcolortext((Int local19), (Int (local20 + 53.0)), format(getlocalstring("language", "full"), "", "%s"), getlocalstring("language", "no"), $FF, $FF, $FF, $C8, $00, $00)
                EndIf
                If (local14\Field5 = $00) Then
                    If (local14\Field8 = "1.5") Then
                        dualcolortext((Int local19), (Int (local20 + 68.0)), format(getlocalstring("language", "compatible"), "", "%s"), ("v" + local14\Field8), $FF, $FF, $FF, $00, $C8, $00)
                    Else
                        dualcolortext((Int local19), (Int (local20 + 68.0)), format(getlocalstring("language", "compatible"), "", "%s"), ("v" + local14\Field8), $FF, $FF, $FF, $C8, $00, $00)
                    EndIf
                    textex((Int local19), (Int (local20 + 83.0)), local27, $00, $00)
                    textex((Int local19), (Int (local20 + 98.0)), local26, $00, $00)
                EndIf
            EndIf
            If (mo\Field0 <> 0) Then
                execfile("https://github.ziyuesinicization.site/Jabka666/scpcb-ue-my/wiki/Language-List-of-Ultimate-Edition")
            EndIf
        EndIf
        local14 = Null
        flip($01)
    Forever
    mo\Field0 = $00
    mo\Field2 = $00
    scrollbary = 0.0
    scrollmenuheight = 0.0
    For local2 = Each listlanguage
        freeimage(s2imapget(countryflags, local2\Field4))
        Delete local2
    Next
    destroys2imap(countryflags)
    countryflags = $00
    freeimage(local10)
    local10 = $00
    freeimage(local9)
    local9 = $00
    freeimage(local11)
    local11 = $00
    freeimage(launcherbg)
    launcherbg = $00
    deletefolder(local1)
    apptitle(getlocalstring("launcher", "title"), "")
    Return $00
End Function
