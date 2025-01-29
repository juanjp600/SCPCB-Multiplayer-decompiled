Function createserverinfo%()
    ue_server = (New mp_server)
    ue_connection = (New mp_connection)
    ue_server\Field4 = "SCP CB UERM COOP Session"
    mp_allowversion($0B)
    Return $00
End Function
