Function mp_updateplayers%(arg0%)
    Local local1.players
    Select arg0
        Case $00
            For local1 = Each players
                mp_getplayer(local1)
            Next
        Case $01
            For local1 = Each players
                mp_updateplayerrole(local1\Field30)
            Next
    End Select
    Return $00
End Function
