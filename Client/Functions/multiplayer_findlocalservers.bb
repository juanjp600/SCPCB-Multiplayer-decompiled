Function multiplayer_findlocalservers%(arg0%)
    Local local0%
    Local local1$
    Local local2%
    Local local3.servers
    For local0 = $01 To counthostips("") Step $01
        local1 = dottedip(hostip(local0))
        local2 = $00
        For local3 = Each servers
            If ((((local3\Field1 = local1) And (local3\Field2 = (Str arg0))) And (local3\Field0 = $04)) <> 0) Then
                local2 = $01
                Exit
            EndIf
        Next
        If (local2 = $00) Then
            local3 = (New servers)
            local3\Field1 = local1
            local3\Field2 = (Str arg0)
            local3\Field10 = ((local1 + ":") + (Str arg0))
            local3\Field4 = $00
            local3\Field5 = "-"
            local3\Field6 = "0 / 0"
            local3\Field9 = "Offline"
            local3\Field0 = $04
            multiplayer_list_updateserver(local3, $1388, $01)
        EndIf
    Next
    Return $00
End Function
