Function checkforupdates%()
    Local local0$
    Local local1$
    Local local2$
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7$[64]
    Local local8$
    Local local9%
    Local local10$
    Local local11%
    Local local12%
    Local local13$
    Local local14.changeloglines
    Local local15%
    Local local16#
    Local local17%
    Local local18%
    Local local19$
    Local local20%
    Local local21$
    Local local22.zipapi_unzfileinfo
    Local local23%
    local0 = "ch"
    local1 = "links"
    deletefile(local0)
    deletefile(local1)
    apptitle("SCP - Containment Breach Multiplayer Updater", "")
    If (((updatecheckenabled = $00) Or $01) <> 0) Then
        Return $00
    EndIf
    setbuffer(backbuffer())
    cls()
    color($FF, $FF, $FF)
    text($140, $F0, "Checking for updates...", $01, $01)
    flip($01)
    local2 = "http://127.0.0.1/"
    local3 = download((local2 + "MPChangeLogOld.txt"), local0, "", $50)
    If (local3 = $00) Then
        local2 = "http://127.0.0.1/"
        local3 = download((local2 + "MPChangeLogOld.txt"), local0, "", $50)
        If (local3 = $00) Then
            Return $00
        EndIf
    EndIf
    local4 = readfile(local0)
    local5 = readline(local4)
    local5 = right(local5, (len(local5) - instr(local5, "v", $01)))
    closefile(local4)
    If (filetype("updates") = $00) Then
        createdir("updates")
    EndIf
    debuglog(("LATEST VERSION: " + local5))
    local6 = $00
    local8 = multiplayer_version
    debuglog(("MULTIPLAYER VERSION: " + local8))
    If (((local5 <> local8) And (local5 <> "")) <> 0) Then
        If (download((local2 + "links.txt"), local1, "", $50) = $00) Then
            Return $00
        EndIf
        local9 = $00
        local4 = readfile(local1)
        While (eof(local4) = $00)
            local7[local9] = readline(local4)
            local9 = (local9 + $01)
        Wend
        closefile(local4)
        deletefile(local1)
        updaterbg = loadimage_strict("GFX\menu\updater.jpg")
        updaterimg = createimage($1C4, $FE, $01)
        local10 = "v1.2.9.6p"
        local11 = readfile(local0)
        While (eof(local11) = $00)
            local13 = readline(local11)
            If (left(local13, $05) <> "-----") Then
                local14 = (New changeloglines)
                If (right(local13, (len(local13) - instr(local13, "v", $01))) = local5) Then
                    local14\Field0 = ("NEW UPDATE: " + local13)
                Else
                    local14\Field0 = local13
                EndIf
            Else
                Exit
            EndIf
        Wend
        closefile(local11)
        deletefile(local0)
        updaterfont = loadfont("GFX\font\cour\Courier New.ttf", $10, $00, $00, $00)
        local15 = $00
        Repeat
            setbuffer(backbuffer())
            cls()
            color($FF, $FF, $FF)
            mousehit1 = mousehit($01)
            mousedown1 = mousedown($01)
            drawimage(updaterbg, $00, $00, $00)
            debuglog((Str local12))
            setfont(updaterfont)
            If (local15 > $0D) Then
                local16 = (200.0 - ((20.0 * scrollmenuheight) * scrollbary))
                local15 = $00
                setbuffer(imagebuffer(updaterimg, $00))
                drawimage(updaterbg, $FFFFFFEC, $FFFFFF3D, $00)
                For local14 = Each changeloglines
                    color($00, $00, $00)
                    If (right(local14\Field0, (len(local14\Field0) - instr(local14\Field0, "v", $01))) = local5) Then
                        color($C8, $00, $00)
                    EndIf
                    rowtext2(local14\Field0, $02, (Int (local16 - 195.0)), $1AE, $FE, $00, 1.0)
                    local16 = ((Float (getlineamount2(local14\Field0, $1AE, $FE, 1.0) * $14)) + local16)
                    local15 = (local15 + getlineamount2(local14\Field0, $1AE, $FE, 1.0))
                Next
                setbuffer(backbuffer())
                drawimage(updaterimg, $14, $C3, $00)
                color($0A, $0A, $0A)
                rect($1C4, $C3, $14, $FE, $01)
                scrollmenuheight = ((Float local15) / 1.2)
                scrollbary = drawscrollbar($1C4, $C3, $14, $FE, $1C4, (Int (((254.0 - (254.0 - (4.0 * scrollmenuheight))) * scrollbary) + 195.0)), $14, (Int (254.0 - (4.0 * scrollmenuheight))), scrollbary, $01)
            Else
                local16 = 200.0
                local15 = $00
                color($00, $00, $00)
                For local14 = Each changeloglines
                    rowtext2(local14\Field0, $14, (Int local16), $1B0, $FE, $00, 1.0)
                    local16 = ((Float (getlineamount2(local14\Field0, $1B0, $FE, 1.0) * $14)) + local16)
                    local15 = (local15 + getlineamount2(local14\Field0, $1B0, $FE, 1.0))
                    local12 = local15
                Next
                scrollmenuheight = (Float local15)
            EndIf
            color($FF, $FF, $FF)
            setfont(font1)
            If (drawbutton(((launcherwidth - $1E) - $64), ((launcherheight - $32) - $37), $64, $1E, "UPDATE", $00, $00, $00, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                sendstatisticrequest($09)
                local6 = $01
                cls()
                color($FF, $FF, $FF)
                text($140, $F0, "Starting download...", $01, $01)
                flip($01)
                delay($64)
                Exit
            EndIf
            If (drawbutton(((launcherwidth - $37) - $64), ((launcherheight - $32) - $6E), $91, $1E, "VISIT WEBSITE", $00, $00, $00, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                sendstatisticrequest($0A)
                execfile("https://store.steampowered.com/app/1782380")
            EndIf
            If (drawbutton(((launcherwidth - $1E) - $64), (launcherheight - $32), $64, $1E, "IGNORE", $00, $00, $00, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00) <> 0) Then
                sendstatisticrequest($0B)
                delay($64)
                Exit
            EndIf
            flip($01)
            If (api_iswindowvisible(screen_hwnd) = $00) Then
                api_showwindow(screen_hwnd, $01)
            EndIf
            delay($08)
        Forever
    EndIf
    If (local6 <> 0) Then
        deletefile((("updates\" + local5) + ".zip"))
        For local18 = $00 To $3F Step $01
            If (local7[local18] <> "") Then
                local17 = download(local7[local18], (("updates\" + local5) + ".zip"), ((local5 + ".zip") + (Str (local18 + $01))), $50)
                If (local17 = $00) Then
                    Exit
                EndIf
            EndIf
        Next
        If (local17 > $00) Then
            If (filesize((("updates\" + local5) + ".zip")) <> $00) Then
                local19 = ""
                local20 = zipapi_open((("updates\" + local5) + ".zip"))
                debuglog((Str local20))
                local17 = (Int ((Str zipapi_gotofirstfile(local20)) + "a"))
                While (local17 = $00)
                    setbuffer(backbuffer())
                    cls()
                    color($FF, $FF, $FF)
                    local21 = ""
                    local22 = zipapi_getcurrentfileinfo(local20)
                    If (local22 <> Null) Then
                        local21 = local22\Field12
                        local23 = local22\Field7
                        zipapi_unzfileinfo_dispose(local22)
                        If (filesize(local21) <> local23) Then
                            If (((right(local21, $01) <> "/") And (right(local21, $01) <> "\")) <> 0) Then
                                If (instr(local21, "zlibwapi.dll", $01) = $00) Then
                                    zipapi_extractfile(local20, local21, local21, "")
                                EndIf
                            ElseIf (filetype(local21) = $00) Then
                                createdir(local21)
                            EndIf
                        EndIf
                        If (((instr(local21, ".exe", $01) > $00) And instr(local21, local5, $01)) <> 0) Then
                            local19 = local21
                        EndIf
                    EndIf
                    If (local21 <> "") Then
                        text($140, $F0, ((("Extracting " + chr($22)) + local21) + chr($22)), $01, $01)
                    EndIf
                    flip($01)
                    local17 = zipapi_gotonextfile(local20)
                    debuglog((Str local17))
                Wend
                zipapi_close(local20, $01)
                execfile((("SCP - Containment Breach Multiplayer Mod v" + local5) + ".exe"))
                end()
            EndIf
        ElseIf (local17 = $FFFFFFFF) Then
            delay($64)
            Return $00
        Else
            setbuffer(backbuffer())
            cls()
            color($FF, $FF, $FF)
            text($140, $F0, "An error has occurred while downloading the update.", $01, $01)
            flip($01)
            delay($3E8)
            Return $00
        EndIf
    EndIf
    Delete Each changeloglines
    If (updaterimg <> $00) Then
        freeimage(updaterimg)
    EndIf
    deletefile(local0)
    deletefile(local1)
    Return $00
End Function
