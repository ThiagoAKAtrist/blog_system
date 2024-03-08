// package blogsystem.repositories.user.jpa;

// import java.util.List;

// import blogsystem.domain.post.entities.Author;
// import blogsystem.domain.user.entities.User;
// import blogsystem.domain.user.gateway.UserGateway;
// import blogsystem.repositories.user.jpa.mapper.UserToUserJpaModelMapper;

// public class UserJpaGateway implements UserGateway{
    
//     private UserJpaRepository userRepository;

//     private UserJpaGateway(final UserJpaRepository userRepository){
//         this.userRepository = userRepository;
//     }
    
//     public static UserJpaGateway build(final UserJpaRepository userRepository){
//         return new UserJpaGateway(userRepository);
//     }


//     @Override
//     public void create(final User user){
//         final var userJpaModel = UserToUserJpaModelMapper.mapper(user);

//         this.userRepository.save(userJpaModel);
//     }
    
//     @Override
//     public User find(String userId) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Author findAuthor(String userId) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<User> list() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void save(User user) {
//         // TODO Auto-generated method stub
        
//     }

    

// }
