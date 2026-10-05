Function updatequery%()
    Local local0.querys
    Local local1%
    Local local2.scriptsthread
    Local local3.se_script
    Local local4.scriptsthread
    Local local5%
    Local local6%
    Local local7%
    Local local8$
    For local0 = Each querys
        If (filepos(local0\Field3) >= local0\Field1) Then
            closefile(local0\Field3)
            freebank(local0\Field10)
            If (local0\Field9 <> $00) Then
                If (unpackserverfile(local0) = $00) Then
                    shouldkick = "Invalid compressed server file"
                EndIf
            ElseIf (local0\Field8 <> 0) Then
                If (se_isvalidscript(local0\Field0) = $00) Then
                    deletefile(("multiplayer\serversdata\" + local0\Field0))
                    shouldkick = "Invalid server script"
                Else
                    local1 = $00
                    For local2 = Each scriptsthread
                        If (local2\Field1 = ("multiplayer\serversdata\" + local0\Field0)) Then
                            local1 = $01
                            Exit
                        EndIf
                    Next
                    If (local1 = $00) Then
                        local3 = se_loadscriptexec(("multiplayer\serversdata\" + local0\Field0))
                        If (local3 = Null) Then
                            shouldkick = "Invalid server script"
                        Else
                            local4 = (New scriptsthread)
                            local4\Field0 = local3
                            local4\Field1 = ("multiplayer\serversdata\" + local0\Field0)
                            skynet_onload($00)
                            init_publics_for_script(local4\Field0)
                            public_inqueue($13, $00)
                            public_update_current(local4\Field0, $00)
                            public_clear()
                        EndIf
                        deletefile(("multiplayer\serversdata\" + local0\Field0))
                    EndIf
                EndIf
            EndIf
            If (shouldkick <> "") Then
                Delete local0
                Return $00
            EndIf
            public_inqueue($15, $00)
            public_addparam(local0\Field0, $03)
            callback()
            udp_writebyte($6F)
            udp_writebyte(networkserver\Field20)
            udp_writeint(local0\Field4)
            udp_writeint(local0\Field1)
            udp_writeshort((Int networkserver\Field31))
            udp_sendmessage($00)
            Delete local0
            Exit
        EndIf
        Exit
    Next
    local5 = $00
    local6 = $00
    For local0 = Each querys
        If (local0\Field3 <> $00) Then
            local5 = (local5 + local0\Field1)
            local6 = (local6 + filepos(local0\Field3))
        EndIf
    Next
    If (previousdownloadpos[$00] = local6) Then
        If (previousdownloadpos[$01] = $00) Then
            previousdownloadpos[$01] = (millisecs() + $1388)
        ElseIf (previousdownloadpos[$01] < millisecs()) Then
            previousdownloadpos[$02] = (millisecs() + $1388)
        EndIf
    Else
        previousdownloadpos[$00] = $00
        previousdownloadpos[$01] = $00
        previousdownloadpos[$02] = $00
    EndIf
    previousdownloadpos[$00] = local6
    If (((local6 <> $00) And (previousdownloadpos[$02] < millisecs())) <> 0) Then
        If (downloadspeedupdate < millisecs()) Then
            downloadspeedbytes = $00
            local7 = $00
            For local0 = Each querys
                If (local0\Field6 <> $00) Then
                    downloadspeedbytes = (downloadspeedbytes + local0\Field6)
                    local7 = (local7 + $01)
                    local0\Field6 = $00
                EndIf
            Next
            downloadspeedbytes = (Int ((Float downloadspeedbytes) / max((Float local7), 1.0)))
            downloadspeedupdate = (millisecs() + $3E8)
        EndIf
        local8 = (((("Loading files (" + (Str getdownloadspeed((Float downloadspeedbytes)))) + " MB/s, ") + (Str (Int countpercent(100.0, (Float local6), (Float local5))))) + "% / 100%)...")
        setcolorex($FF, $FF, $FF)
        setfontex(fonts[$00]\Field0)
        text((Int ((Float (graphicwidth - stringwidth(local8))) - (30.0 * menuscale))), (graphicheight - $2D), local8, $00, $00)
        loading_frame = playanimimage(mpimg\Field7, (Int ((Float (graphicwidth - stringwidth(local8))) - (70.0 * menuscale))), (graphicheight - $32), (0.05 * fpsfactor), loading_frame, 11.0)
    EndIf
    Return $00
End Function
