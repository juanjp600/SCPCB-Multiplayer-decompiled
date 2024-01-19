Function multiplayer_updateplayerroom%(arg0.players)
    Local local0%
    Local local1#
    Local local2#
    Local local3.rooms
    Local local4%
    Local local5.rooms
    local0 = $00
    local3 = room[arg0\Field32]
    If (local3 <> Null) Then
        If (1.5 > (Abs (entityy(arg0\Field62, $00) - entityy(local3\Field2, $00)))) Then
            local1 = (Abs (local3\Field3 - entityx(arg0\Field62, $00)))
            local2 = (Abs (local3\Field5 - entityz(arg0\Field62, $00)))
            If (4.0 > local1) Then
                If (4.0 > local2) Then
                    local0 = $01
                EndIf
            EndIf
            If (local0 = $00) Then
                For local4 = $00 To $03 Step $01
                    If (local3\Field32[local4] <> Null) Then
                        local1 = (Abs (local3\Field32[local4]\Field3 - entityx(arg0\Field62, $01)))
                        If (4.0 > local1) Then
                            local2 = (Abs (local3\Field32[local4]\Field5 - entityz(arg0\Field62, $01)))
                            If (4.0 > local2) Then
                                mp_setplayerroomid(arg0, local3\Field32[local4])
                                mp_setroomnametoplayer(arg0)
                                Return $00
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        Else
            local0 = $01
        EndIf
    EndIf
    If (local0 = $00) Then
        For local5 = Each rooms
            If (local5 <> local3) Then
                local1 = (Abs (local5\Field3 - entityx(arg0\Field62, $00)))
                local2 = (Abs (local5\Field5 - entityz(arg0\Field62, $00)))
                If (4.0 > local1) Then
                    If (4.0 > local2) Then
                        If (1.5 > (Abs (entityy(arg0\Field62, $00) - entityy(local5\Field2, $00)))) Then
                            mp_setplayerroomid(arg0, local5)
                            mp_setroomnametoplayer(arg0)
                            Return $00
                        EndIf
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function
